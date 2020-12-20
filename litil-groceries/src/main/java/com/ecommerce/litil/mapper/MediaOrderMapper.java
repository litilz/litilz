package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.MediaOrderEntity;
import com.ecommerce.litil.vo.MediaOrderVO;
import org.springframework.beans.BeanUtils;

public class MediaOrderMapper {
    public static void convertMediaOrdersVOtoMediaOrdersEntity(MediaOrderVO mediaOrdersVO, MediaOrderEntity mediaOrdersEntity) {

        BeanUtils.copyProperties(mediaOrdersVO, mediaOrdersEntity);
    }

    public static void convertMediaOrdersEntitytoMediaOrdersVO(MediaOrderVO mediaOrdersVO, MediaOrderEntity mediaOrdersEntity) {

        BeanUtils.copyProperties(mediaOrdersEntity, mediaOrdersVO);
    }
}
