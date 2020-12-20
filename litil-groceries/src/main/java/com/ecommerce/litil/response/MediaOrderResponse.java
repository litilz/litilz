package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.MediaOrderVO;

import java.util.List;

public class MediaOrderResponse extends BaseResponse {

    private List<MediaOrderVO> mediaOrdersVO;


    public List<MediaOrderVO> getMediaOrdersVO() {
        return mediaOrdersVO;
    }

    public void setMediaOrdersVO(List<MediaOrderVO> mediaOrdersVO) {
        this.mediaOrdersVO = mediaOrdersVO;
    }

}
