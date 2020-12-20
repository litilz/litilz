package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.MediaOrderVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaOrderRequest {

    @JsonProperty("Media")
    private MediaOrderVO mediaOrderVO;

    public MediaOrderVO getMediaOrderVO() {
        return mediaOrderVO;
    }

    public void setMediaOrderVO(MediaOrderVO mediaOrderVO) {
        this.mediaOrderVO = mediaOrderVO;
    }

}
