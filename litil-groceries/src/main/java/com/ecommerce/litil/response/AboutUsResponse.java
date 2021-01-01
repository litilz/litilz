package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.AboutUsVO;
import com.ecommerce.repos.response.BaseResponse;

import java.util.List;

public class AboutUsResponse extends BaseResponse {
    List<AboutUsVO> aboutUsVO;

    public List<AboutUsVO> getAboutUsVO() {
        return aboutUsVO;
    }

    public void setAboutUsVO(List<AboutUsVO> aboutUsVO) {
        this.aboutUsVO = aboutUsVO;
    }
}

