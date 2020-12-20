package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.OffersNotifierVO;

public class OffersNotifierResponse extends BaseResponse {

    private OffersNotifierVO offersNotifierVO;

    public OffersNotifierVO getOffersNotifierVO() {
        return offersNotifierVO;
    }

    public void setOffersNotifierVO(OffersNotifierVO offersNotifierVO) {
        this.offersNotifierVO = offersNotifierVO;
    }
}
