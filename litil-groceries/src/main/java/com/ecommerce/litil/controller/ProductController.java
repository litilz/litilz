package com.ecommerce.litil.controller;

import com.ecommerce.litil.repository.ProductRepository;
import com.ecommerce.litil.response.CategoryResponse;
import com.ecommerce.litil.response.ProductResponse;
import com.ecommerce.litil.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product", produces = "application/json")
public class ProductController {


    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;
    


    @GetMapping("/getCategories")
    public CategoryResponse getCategories() {
        return productService.getCategories();
    }

    @GetMapping(value = "/category/{category}")
    public ProductResponse getProductsByCategory(@PathVariable("category") String category, @RequestParam(name = "user_name") String user_name) {
        return productService.getProductsByCategory(category, user_name);
    }

//    @PostMapping("/addProduct")
//    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
//        return productService.addProduct(productRequest);
//    }
//
//    @PostMapping("/addCategory")
//    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest) {
//        return productService.addCategory(categoryRequest);
//    }

    @GetMapping(value = "/{productname}")
    public ProductResponse getProductsByProductName(@PathVariable("productname") String productname) {
        return productService.getProductsByProductName(productname);
    }
}
