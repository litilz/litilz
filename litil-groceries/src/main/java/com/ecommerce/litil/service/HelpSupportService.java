package com.ecommerce.litil.service;


import com.ecommerce.repos.entity.HelpSupportEntity;
import com.ecommerce.litil.mapper.AboutUsMapper;
import com.ecommerce.repos.repository.HelpSupportRepository;
import com.ecommerce.litil.request.HelpSupportRequest;
import com.ecommerce.litil.response.HelpSupportResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.HelpSupportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelpSupportService {

    @Autowired
    HelpSupportRepository helpSupportRepository;

    public HelpSupportResponse getHelpSupport() {

        HelpSupportResponse helpSupportResponse = new HelpSupportResponse();

        List<HelpSupportEntity> hSEntity = helpSupportRepository.findAll();
        List<HelpSupportVO> hSVOList = new ArrayList<>();

        for (HelpSupportEntity hEntity : hSEntity) {
            HelpSupportVO hsVO = new HelpSupportVO();
            AboutUsMapper.convertHelpSupportEntitytoHelpSupportVO(hsVO, hEntity);
            hSVOList.add(hsVO);
        }
        helpSupportResponse.setHelpSupportVO(hSVOList);
        helpSupportResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        helpSupportResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);

        return helpSupportResponse;
    }

    public HelpSupportResponse addHelpSupport(HelpSupportRequest helpSupportRequest) {

        HelpSupportResponse helpSupportResponse = new HelpSupportResponse();

        HelpSupportEntity hSEntity = new HelpSupportEntity();
        List<HelpSupportVO> helpSupportVOList = new ArrayList<>();

        AboutUsMapper.convertHelpSupportVOtoHelpSupportEntity(helpSupportRequest.getHelpSupportVO(), hSEntity);
        helpSupportRepository.save(hSEntity);


        helpSupportResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        helpSupportResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);

        return helpSupportResponse;
    }
}
