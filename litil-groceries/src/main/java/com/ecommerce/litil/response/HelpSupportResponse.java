package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.HelpSupportVO;

import java.util.List;

public class HelpSupportResponse extends BaseResponse {

    List<HelpSupportVO> helpSupportVO;

    public List<HelpSupportVO> getHelpSupportVO() {
        return helpSupportVO;
    }

    public void setHelpSupportVO(List<HelpSupportVO> helpSupportVO) {
        this.helpSupportVO = helpSupportVO;
    }
}
