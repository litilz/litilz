package com.ecommerce.litil.mapper;

import com.ecommerce.repos.entity.ProductEntity;
import com.ecommerce.litil.vo.ProductVO;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static void convertProductVOtoProductEntity(ProductVO productVO, ProductEntity productEntity) {
        BeanUtils.copyProperties(productVO, productEntity);
    }

    public static void convertProductEnitytoProductVO(ProductVO productVO, ProductEntity productEntity) {
        BeanUtils.copyProperties(productEntity, productVO);
    }
}
