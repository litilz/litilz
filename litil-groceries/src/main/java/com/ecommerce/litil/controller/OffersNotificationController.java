package com.ecommerce.litil.controller;


import com.ecommerce.repos.entity.NotificationsEntity;
import com.ecommerce.repos.entity.OffersEntity;
import com.ecommerce.repos.repository.NotificationsRepository;
import com.ecommerce.repos.repository.OffersRepository;
import com.ecommerce.litil.response.OffersNotifierResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.OffersNotifierVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/offersNotifier")
public class OffersNotificationController {

    private static final Logger logger = LoggerFactory.getLogger(OffersNotificationController.class);

    @Autowired
    OffersRepository offersRepository;

    @Autowired
    NotificationsRepository notificationsRepository;


    @GetMapping(value = "/offers")
    public OffersNotifierResponse getOffersUrl() {

        OffersNotifierResponse offersNotifierResponse = new OffersNotifierResponse();

        List<OffersEntity> offersList = offersRepository.findAll();
        List<NotificationsEntity> notificationList = notificationsRepository.findAll();


        if (!CollectionUtils.isEmpty(offersList) || !CollectionUtils.isEmpty(notificationList)) {
            OffersNotifierVO offersNotifierVO = new OffersNotifierVO();
            offersNotifierVO.setNotifierList(notificationList);
            offersNotifierVO.setOffersList(offersList);
            offersNotifierResponse.setOffersNotifierVO(offersNotifierVO);
            offersNotifierResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            return offersNotifierResponse;
        } else {
            offersNotifierResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            offersNotifierResponse.setStatusDesc("either of notifier or offers not updated");
            return offersNotifierResponse;
        }


    }

}
