package com.ecommerce.restaurant.mapper;

import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.vo.ItemsVO;
import org.springframework.beans.BeanUtils;

public class ItemsMapper {

    public static void convertItemEntitytoItemVO(ItemsEntity itemsEntity, ItemsVO itemsVO) {

        BeanUtils.copyProperties(itemsEntity, itemsVO);
    }
}
