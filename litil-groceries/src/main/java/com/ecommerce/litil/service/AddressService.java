package com.ecommerce.litil.service;

import com.ecommerce.litil.exception.LitilException;
import com.ecommerce.litil.mapper.AddressMapper;
import com.ecommerce.litil.request.AddressRequest;
import com.ecommerce.litil.response.AddressResponse;
import com.ecommerce.litil.response.BaseResponse;
import com.ecommerce.litil.response.PincodeResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.AddressVO;
import com.ecommerce.repos.entity.AddressBuilder;
import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.PincodeEntity;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.repository.AddressRepository;
import com.ecommerce.repos.repository.PincodeRepository;
import com.ecommerce.repos.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PincodeRepository pincodeRepository;

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Transactional
    public AddressResponse addAddress(AddressRequest addressRequest) {
        AddressResponse addressResponse = new AddressResponse();
        if (addressRequest == null || addressRequest.getAddressVO() == null) {
            throw new LitilException("No address object found");
        }

        AddressEntity newAddress = new AddressEntity();
        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(addressRequest.getAddressVO().getUser_name());
        List<AddressEntity> addressEntityList = addressRepository.findUserAddress(userEntityOptional, Boolean.TRUE);
        newAddress.setUser_id(userEntityOptional);
        newAddress.setActive(Boolean.FALSE);

        if (CollectionUtils.isEmpty(addressEntityList)) {
            AddressMapper.convertAddressVOtoAddressEnity(addressRequest.getAddressVO(), newAddress);
            newAddress.setActive(Boolean.TRUE);
        } else {
            AddressMapper.convertAddressVOtoAddressEnity(addressRequest.getAddressVO(), newAddress);
            addressEntityList.forEach(list -> {
                if (list.getActive() == Boolean.TRUE) {
                    newAddress.setActive(Boolean.TRUE);
                    list.setActive(Boolean.FALSE);
                    addressRepository.save(list);
                }
            });
            if (newAddress.getActive().equals(Boolean.FALSE)) {
                newAddress.setActive(Boolean.TRUE);
            }
        }
        newAddress.setEnabled(Boolean.TRUE);
        addressRepository.save(newAddress);

        AddressResponse aResponse = getAllAddress(userEntityOptional.getUser_name());
        addressResponse.setAddressList(aResponse.getAddressList());
        addressResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        addressResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return addressResponse;

    }

    public AddressResponse getAllAddress(String user_name) {
        AddressResponse addressResponse = new AddressResponse();
        if (user_name == null) {
            throw new LitilException("No address object found");
        }
        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(user_name);
        List<AddressVO> addressList = new ArrayList<AddressVO>();
        if (userEntityOptional.getUser_name() != null) {
            List<AddressEntity> addressEntityList = addressRepository.findUserAddress(userEntityOptional, Boolean.TRUE);
            if (addressEntityList != null && !addressEntityList.isEmpty()) {
                for (AddressEntity addressEntity : addressEntityList) {
                    AddressVO addressVO = new AddressVO();
                    addressVO.setUser_name(user_name);
                    AddressMapper.convertAddressEntitytoAddressVO(addressVO, addressEntity);
                    addressList.add(addressVO);
                }
                addressResponse.setAddressList(addressList);
                addressResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
                addressResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
            } else {
                addressResponse.setStatusDesc("User not existed");
                addressResponse.setStatusCode(LitilConstants.FAILURE_CODE);
                addressResponse.setStatusDesc(LitilConstants.FAILURE_DESC);
            }
        }
        return addressResponse;
    }

    public PincodeResponse getPincode() {
        List<PincodeEntity> pincodeList = pincodeRepository.findAll();
        PincodeResponse pincodeResponse = new PincodeResponse();
        if (pincodeList.isEmpty()) {
            pincodeResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            pincodeResponse.setStatusDesc("please add delivery pincodes");
        } else {
            pincodeResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            pincodeResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
            pincodeResponse.setPincode(pincodeList);
        }
        return pincodeResponse;
    }

    public BaseResponse deleteAddress(Integer id) {
        BaseResponse bResponse = new BaseResponse();
        addressRepository.deleteAddress(id, Boolean.FALSE);
        bResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        bResponse.setStatusDesc("address deleted successfully");
        return bResponse;
    }


    public BaseResponse setActive(Integer id, String user_id) {
        AddressEntity newActive = addressRepository.findById(id).get();
        BaseResponse baseResponse = new BaseResponse();
        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(user_id);
        AddressEntity oldActive = addressRepository.findDefault(userEntityOptional, Boolean.TRUE, Boolean.TRUE);
        if (oldActive != null) {
            newActive.setActive(Boolean.TRUE);
            oldActive.setActive(Boolean.FALSE);
            addressRepository.save(oldActive);
            addressRepository.save(newActive);
        } else {
            newActive.setActive(Boolean.TRUE);
            addressRepository.save(newActive);
        }
        baseResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        baseResponse.setStatusCode(LitilConstants.SUCCESS_CODE);

        return baseResponse;
    }


    @Transactional
    public AddressResponse updateAddress(AddressRequest addressRequest) {
        AddressEntity updateAddress = addressRepository.findById(addressRequest.getAddressVO().getId()).get();
        AddressVO addressVO = addressRequest.getAddressVO();
        AddressResponse addressResponse = new AddressResponse();
        UserEntity userEntityOptional = userRepository.getUserByPhoneNumber(addressVO.getUser_name());
        updateAddress = new AddressBuilder().setId(addressVO.getId()).setName(addressVO.getName()).setCity(addressVO.getCity())
                .setCountry(addressVO.getCountry()).setLandmark(addressVO.getLandmark()).setLine1(addressVO.getLine1())
                .setMobile(addressVO.getMobile()).setState(addressVO.getState()).setPincode(addressVO.getPincode())
                .setUser_id(userEntityOptional).setEnabled(Boolean.TRUE).getAddressEntity();
        setActive(addressVO.getId(), addressVO.getUser_name());
        addressRepository.save(updateAddress);
        AddressResponse response = getAllAddress(addressVO.getUser_name());
        addressResponse.setAddressList(response.getAddressList());
        addressResponse.setStatusDesc("Address Updated successfully");
        addressResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        return addressResponse;

    }
}