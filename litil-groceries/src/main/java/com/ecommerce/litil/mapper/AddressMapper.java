package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.AddressEntity;
import com.ecommerce.litil.vo.AddressVO;
import org.springframework.beans.BeanUtils;

public class AddressMapper {

    public static void convertAddressVOtoAddressEnity(AddressVO addressVO, AddressEntity addressEntity) {

        BeanUtils.copyProperties(addressVO, addressEntity);
    }

    public static void convertAddressEntitytoAddressVO(AddressVO addressVO, AddressEntity addressEntity) {

        BeanUtils.copyProperties(addressEntity, addressVO);
    }
}