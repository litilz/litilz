package com.ecommerce.litil.mapper;


import com.ecommerce.repos.entity.MediaOrderEntity;
import com.ecommerce.litil.vo.MediaOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class MediaOrderMapper {

    @Autowired
    MediaOrderEntity mediaOrderEntity;

    public static void convertMediaOrdersVOtoMediaOrdersEntity(MediaOrderVO mediaOrdersVO, MediaOrderEntity mediaOrdersEntity) {

        BeanUtils.copyProperties(mediaOrdersVO, mediaOrdersEntity);
    }

    public static void convertMediaOrdersEntitytoMediaOrdersVO(MediaOrderVO mediaOrdersVO, MediaOrderEntity mediaOrdersEntity) {

        BeanUtils.copyProperties(mediaOrdersEntity, mediaOrdersVO);
    }
}
