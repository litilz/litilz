//package com.ecommerce.litil.service;
//
//
//import com.ecommerce.litil.entity.MediaOrderEntity;
//import com.ecommerce.litil.repository.MediaOrderRepository;
//import com.ecommerce.repos.exception.LitilException;
//import com.ecommerce.litil.mapper.CategoryMapper;
//import com.ecommerce.litil.mapper.MediaOrderMapper;
//import com.ecommerce.litil.request.MediaOrderRequest;
//import com.ecommerce.litil.response.CategoryResponse;
//import com.ecommerce.litil.response.MediaOrderResponse;
//import com.ecommerce.litil.vo.CategoryVO;
//import com.ecommerce.litil.vo.MediaOrderVO;
//import com.ecommerce.repos.entity.MediaCategoriesEntity;
//import com.ecommerce.repos.entity.UserEntity;
//import com.ecommerce.repos.repository.MediaCategoriesRepository;
//import com.ecommerce.repos.repository.UserRepository;
//import com.ecommerce.repos.twilio.TwilioService;
//import com.ecommerce.repos.util.LitilConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class MediaService {
//
//    @Autowired
//    MediaCategoriesRepository mediaCategoriesRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    TwilioService twilioService;
//
//    @Autowired
//    MediaOrderRepository mediaOrderRepository;
//
//    public CategoryResponse getCategories() {
//        List<MediaCategoriesEntity> mList = mediaCategoriesRepository.findAll();
//        List<CategoryVO> lCart = new ArrayList<>();
//        mList.forEach(x -> {
//            CategoryVO categoryVO = new CategoryVO();
//            CategoryMapper.convertCategoryEntitytoCategoryVO(categoryVO, x);
//            lCart.add(categoryVO);
//        });
//        CategoryResponse categoryResponse = new CategoryResponse();
//        categoryResponse.setCategories(lCart);
//
//        return categoryResponse;
//
//    }
//
//    // Creating MediaOrders
//    public MediaOrderResponse createMediaOrder(MediaOrderRequest mediaOrderRequest) {
//        MediaOrderEntity mediaOrderEntity = new MediaOrderEntity();
//        Long previousTime;
//        MediaOrderResponse mediaOrdersResponse = new MediaOrderResponse();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        Date now = new Date();
//        synchronized (this) {
//            previousTime = System.currentTimeMillis();
//        }
//        if (mediaOrderRequest == null || mediaOrderRequest.getMediaOrderVO() == null) {
//            throw new LitilException("Invalid request object");
//        }
//        MediaOrderMapper.convertMediaOrdersVOtoMediaOrdersEntity(mediaOrderRequest.getMediaOrderVO(), mediaOrderEntity);
//        mediaOrderEntity.setId(previousTime);
//        mediaOrderEntity.setOrdered(now);
//        mediaOrderEntity.setStatus(LitilConstants.ORDERED);
//        UserEntity uEntity = userRepository.getUserByPhoneNumber(mediaOrderRequest.getMediaOrderVO().getUser_id());
//        mediaOrderEntity.setUser_id(uEntity);
//        mediaOrderRepository.save(mediaOrderEntity);
//        mediaOrdersResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
//        mediaOrdersResponse.setStatusDesc(previousTime.toString());
//        if (mediaOrdersResponse.getStatusCode().equals(LitilConstants.SUCCESS_CODE)) {
//            twilioService.sendDetails(mediaOrderRequest.getMediaOrderVO().getUser_id(), previousTime);
//        }
//        return mediaOrdersResponse;
//    }
//
//    // Getting all MediaOrders
//    public MediaOrderResponse getAllUserMediaOrders(String user_name) {
//        MediaOrderResponse mediaOrderResponse = new MediaOrderResponse();
//        List<MediaOrderVO> mVOList = new ArrayList<>();
//        UserEntity uEntity = userRepository.getUserByPhoneNumber(user_name);
//        List<MediaOrderEntity> mOrderList = mediaOrderRepository.findAllUserOrders(uEntity);
//        for (MediaOrderEntity mEntity : mOrderList) {
//            MediaOrderVO mOrdersVO = new MediaOrderVO();
//            MediaOrderMapper.convertMediaOrdersEntitytoMediaOrdersVO(mOrdersVO, mEntity);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date ordered = mEntity.getOrdered();
//            mOrdersVO.setOrdered(dateFormat.format(ordered));
//            mOrdersVO.setUser_id(user_name);
//            mVOList.add(mOrdersVO);
//        }
//        mediaOrderResponse.setMediaOrdersVO(mVOList);
//        mediaOrderResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
//        mediaOrderResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
//        return mediaOrderResponse;
//    }
//}
