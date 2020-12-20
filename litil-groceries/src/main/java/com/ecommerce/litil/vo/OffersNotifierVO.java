package com.ecommerce.litil.vo;

import com.ecommerce.litil.entity.NotificationsEntity;
import com.ecommerce.litil.entity.OffersEntity;

import java.util.List;

public class OffersNotifierVO {


    private List<OffersEntity> offersList;
    private List<NotificationsEntity> notifierList;

    public List<OffersEntity> getOffersList() {
        return offersList;
    }

    public void setOffersList(List<OffersEntity> offersList) {
        this.offersList = offersList;
    }

    public List<NotificationsEntity> getNotifierList() {
        return notifierList;
    }

    public void setNotifierList(List<NotificationsEntity> notifierList) {
        this.notifierList = notifierList;
    }
}
