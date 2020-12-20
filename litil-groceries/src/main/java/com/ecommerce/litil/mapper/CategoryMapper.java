package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.CategoryEntity;
import com.ecommerce.litil.entity.MediaCategoriesEntity;
import com.ecommerce.litil.vo.CategoryVO;
import org.springframework.beans.BeanUtils;

public class CategoryMapper {

    public static void convertCategoryEntitytoCategoryVO(CategoryVO categoryVO, CategoryEntity categoryEntity) {
        BeanUtils.copyProperties(categoryEntity, categoryVO);
    }

    public static void convertCategoryVOtoCategoryEntity(CategoryVO categoryVO, CategoryEntity categoryEntity) {
        BeanUtils.copyProperties(categoryVO, categoryEntity);
    }

    public static void convertCategoryEntitytoCategoryVO(CategoryVO categoryVO, MediaCategoriesEntity mediaCategoriesEntity) {
        BeanUtils.copyProperties(mediaCategoriesEntity, categoryVO);
    }

    public static void convertCategoryVOtoCategoryEntity(CategoryVO categoryVO, MediaCategoriesEntity mediaCategoriesEntity) {
        BeanUtils.copyProperties(categoryVO, mediaCategoriesEntity);
    }
}
