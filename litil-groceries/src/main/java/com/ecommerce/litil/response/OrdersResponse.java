package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.MediaOrderVO;
import com.ecommerce.litil.vo.OrdersVO;
import com.ecommerce.repos.response.BaseResponse;

import java.util.List;

public class OrdersResponse extends BaseResponse {


    private List<OrdersVO> ordersVO;

    private List<MediaOrderVO> mediaOrdersVO;

    public List<MediaOrderVO> getMediaOrdersVO() {
        return mediaOrdersVO;
    }

    public void setMediaOrdersVO(List<MediaOrderVO> mediaOrdersVO) {
        this.mediaOrdersVO = mediaOrdersVO;
    }

    public List<OrdersVO> getOrdersVO() {
        return ordersVO;
    }

    public void setOrdersVO(List<OrdersVO> ordersVO) {
        this.ordersVO = ordersVO;
    }
}
