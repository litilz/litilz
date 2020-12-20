package com.ecommerce.litil.service;

import com.ecommerce.litil.entity.ProductEntity;
import com.ecommerce.litil.entity.UserEntity;
import com.ecommerce.litil.entity.WishItemsEntity;
import com.ecommerce.litil.exception.LitilException;
import com.ecommerce.litil.mapper.ProductMapper;
import com.ecommerce.litil.repository.ProductRepository;
import com.ecommerce.litil.repository.UserRepository;
import com.ecommerce.litil.repository.WishRepository;
import com.ecommerce.litil.request.WishRequest;
import com.ecommerce.litil.response.WishResponse;
import com.ecommerce.litil.util.LitilConstants;
import com.ecommerce.litil.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishRepository wishRepository;

    public WishResponse addRemoveItem(WishRequest wishRequest) {
        if (wishRequest == null || wishRequest.getWishVo() == null) {
            throw new LitilException("Invalid Wish Request Parameters");
        }

        WishResponse wishResponse = new WishResponse();
        UserEntity uEntity = userRepository.getUserByPhoneNumber(wishRequest.getWishVo().getUser_name());
        ProductEntity pEntity = productRepository.findById(wishRequest.getWishVo().getProductId()).get();

        if (wishRequest.getWishVo().getWishFlag()) {
            WishItemsEntity wishItemsEntity = new WishItemsEntity();
            wishItemsEntity.setProductid(pEntity);
            wishItemsEntity.setUser_id(uEntity);
            wishRepository.save(wishItemsEntity);
        } else {
            wishRepository.deleteWishListByUserIdAndProductId(uEntity, pEntity);
        }

        wishResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        wishResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return wishResponse;
    }

    public WishResponse getWishListByUserId(String user_name) {
        WishResponse wishResponse = new WishResponse();

        List<ProductVO> productList = new ArrayList<ProductVO>();
        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(user_name);
        List<ProductEntity> productIds = wishRepository.getUserIdsByUserNames(userEntityOptional);
        for (ProductEntity plist : productIds) {
            ProductVO productVO = new ProductVO();
            ProductMapper.convertProductEnitytoProductVO(productVO, plist);
            productList.add(productVO);
        }
        wishResponse.setProductList(productList);
        wishResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        wishResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return wishResponse;
    }
}
