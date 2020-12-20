package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.UserEntity;
import com.ecommerce.litil.vo.UserVO;
import org.springframework.beans.BeanUtils;

public class UserMapper {


    public static void convertUserVOtoUserEnity(UserVO userVo, UserEntity userEntity) {
        BeanUtils.copyProperties(userVo, userEntity);
    }

    public static void convertUserEntitytoUserVO(UserVO userVo, UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, userVo);
        userVo.setUser_name(userEntity.getUser_name());
    }
}
