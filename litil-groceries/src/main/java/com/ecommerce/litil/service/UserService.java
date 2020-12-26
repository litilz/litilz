package com.ecommerce.litil.service;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.litil.exception.LitilException;
import com.ecommerce.litil.mapper.UserMapper;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.litil.request.UserRequest;
import com.ecommerce.litil.response.BaseResponse;
import com.ecommerce.litil.response.UserResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public UserResponse saveUser(UserRequest userRequest) {
        if (userRequest == null || userRequest.getUser() == null) {
            throw new LitilException("User Request details");
        }
        UserEntity userEntity = userRepository.getUserByPhoneNumber(userRequest.getUser().getPhone());
        UserResponse userResponse = new UserResponse();
        userEntity = userEntity == null ? new UserEntity() : userEntity;
        UserVO userVo = userRequest.getUser();
        UserMapper.convertUserVOtoUserEnity(userVo, userEntity);
        userEntity.setUser_name(userRequest.getUser().getUser_name() == null ? userRequest.getUser().getPhone() : userRequest.getUser().getUser_name());
        userRepository.save(userEntity);
        userResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        userResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return userResponse;
    }

    public UserResponse getUser(String userName) {
        UserVO userVo = new UserVO();
        if (userName == null) {
            throw new LitilException("UserID is mandatory");
        }
        UserResponse userResponse = new UserResponse();

        List<UserEntity> lEntity = userRepository.findAll();

        UserEntity userEntity = userRepository.getUserByPhoneNumber(userName);
        if (userEntity != null && userEntity.getUser_name() != null) {
            UserMapper.convertUserEntitytoUserVO(userVo, userEntity);
            userResponse.setUser(userVo);
            userResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            userResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
            return userResponse;
        } else {
            userResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            userResponse.setStatusDesc("No User found -> Please enter user name");
            return userResponse;
        }

    }

    public BaseResponse getUserByPhone(String phone) {
        UserEntity response = userRepository.getUserByPhoneNumber(phone);
        if (response == null) {
            return savePhoneNumber(phone);
        }
        BaseResponse baseResponse = new BaseResponse(HttpStatus.OK.name(), "Retrieved user successfully");
        baseResponse.setObject(response);
        return baseResponse;
    }

    private BaseResponse savePhoneNumber(String phone) {
        UserEntity user = new UserEntity();
        user.setUser_name(phone);
        user.setPhone(phone);

        try {
            userRepository.save(user);
            BaseResponse baseResponse = new BaseResponse(HttpStatus.CREATED.name(), "Saved User Successfully");
            baseResponse.setObject(user);
            return baseResponse;
        } catch (Exception e) {
            logger.error("Failed to save user: {} exception: {}", phone, e);
            return new BaseResponse(HttpStatus.BAD_REQUEST.name(), "Failed to save user");
        }
    }
}