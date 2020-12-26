package com.ecommerce.litil.service;

import com.ecommerce.repos.entity.CartEntity;
import com.ecommerce.repos.entity.CategoryEntity;
import com.ecommerce.repos.entity.ProductEntity;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.litil.mapper.CategoryMapper;
import com.ecommerce.litil.mapper.ProductMapper;
import com.ecommerce.repos.repository.*;
import com.ecommerce.litil.request.CategoryRequest;
import com.ecommerce.litil.request.ProductRequest;
import com.ecommerce.litil.response.CategoryResponse;
import com.ecommerce.litil.response.ProductResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.CategoryVO;
import com.ecommerce.litil.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static boolean availability = true;

    private static int quantity = 0;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private WishService wishService;
    @Autowired
    private WishRepository wishRepository;
    @Autowired
    private UserRepository userRepository;

    public CategoryResponse getCategories() {
        CategoryResponse categoryResponse = new CategoryResponse();
        List<CategoryEntity> categories = categoryRepository.findAllCategory();
        List<CategoryVO> catVOList = new ArrayList<>();
        categories.forEach(x -> {
            CategoryVO categoryVO = new CategoryVO();
            CategoryMapper.convertCategoryEntitytoCategoryVO(categoryVO, x);
            catVOList.add(categoryVO);
        });
        categoryResponse.setCategories(catVOList);
        return categoryResponse;
    }

    public ProductResponse getProductsByCategory(String categoryname, String username) {

        List<ProductEntity> productEntityList = productRepository.findByCategory(categoryname, availability);
        List<ProductVO> productList = new ArrayList<ProductVO>();
        ProductResponse productResponse = new ProductResponse();

        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(username);
        List<ProductEntity> productWishList = wishRepository.getUserIdsByUserNames(userEntityOptional);
        List<CartEntity> cartEntityList = cartRepository.findAll(userEntityOptional);


        if (!CollectionUtils.isEmpty(productEntityList)) {
            for (ProductEntity productEntity : productEntityList) {
                ProductVO productVO = new ProductVO();
                ProductMapper.convertProductEnitytoProductVO(productVO, productEntity);
                if (!CollectionUtils.isEmpty(productWishList) && contains(productWishList, productEntity)) {
                    productVO.setFavourite(Boolean.TRUE);
                } else {
                    productVO.setFavourite(Boolean.FALSE);
                }
                if (!CollectionUtils.isEmpty(cartEntityList)) {
                    for (CartEntity c : cartEntityList) {
                        if (c.getProductid().getId() == productEntity.getId()) {
                            productVO.setQuantity(c.getQuantity());
                        }
                    }
                }
                if (productVO.getQuantity() == null) {
                    productVO.setQuantity(ProductService.quantity);
                }
                productList.add(productVO);
            }
        }
        productResponse.setProductList(productList);

        productResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        productResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return productResponse;
    }


    private boolean contains(List<ProductEntity> productWishList, ProductEntity productEntity) {
        return productWishList.stream().filter(o -> o.getId() == productEntity.getId()).findFirst().isPresent();
    }


    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        ProductEntity productEntity = new ProductEntity();
        if (productRequest != null && productRequest.getProductVO() != null) {
            ProductMapper.convertProductVOtoProductEntity(productRequest.getProductVO(), productEntity);
            productEntity.setAvailability(true);
            productRepository.save(productEntity);
            productResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            productResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
            return productResponse;
        } else {
            productResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            productResponse.setStatusDesc("Please fill all the  product details");
            return productResponse;
        }


    }

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {

        CategoryResponse categoryResponse = new CategoryResponse();
        CategoryEntity categoryEntity = new CategoryEntity();
        if (categoryRequest != null && categoryRequest.getCategoryVO() != null) {
            CategoryMapper.convertCategoryVOtoCategoryEntity(categoryRequest.getCategoryVO(), categoryEntity);
            categoryRepository.save(categoryEntity);

            categoryResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            categoryResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
            return categoryResponse;
        } else {
            categoryResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            categoryResponse.setStatusDesc("Please enter category and paste image_url");
            return categoryResponse;
        }
    }

    public ProductResponse getProductsByProductName(String productName) {
        ProductResponse productResponse = new ProductResponse();
        if (StringUtils.isEmpty(productName)) {
            productResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            productResponse.setStatusDesc("Please enter product name");
            return productResponse;
        }
        List<ProductEntity> productEntityList = productRepository.findProductByName(productName);
        List<ProductVO> productList = new ArrayList<ProductVO>();
        if (!CollectionUtils.isEmpty(productEntityList)) {
            for (ProductEntity productEntity : productEntityList) {
                ProductVO productVO = new ProductVO();
                ProductMapper.convertProductEnitytoProductVO(productVO, productEntity);
                if (productVO.getQuantity() == null) {
                    productVO.setQuantity(ProductService.quantity);
                }
                productList.add(productVO);
            }
        }
        productResponse.setProductList(productList);

        productResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        productResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return productResponse;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}



