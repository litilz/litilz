package com.ecommerce.litil.service;

import com.ecommerce.litil.mapper.AboutUsMapper;
import com.ecommerce.litil.request.AboutUSRequest;
import com.ecommerce.litil.response.AboutUsResponse;
import com.ecommerce.litil.vo.AboutUsVO;
import com.ecommerce.repos.entity.AboutUsEntity;
import com.ecommerce.repos.repository.AboutUsRepository;
import com.ecommerce.repos.util.LitilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AboutUsService {


    @Autowired
    AboutUsRepository aboutUsRepository;

    public AboutUsResponse getaboutUs() {
        AboutUsResponse aboutUsResponse = new AboutUsResponse();
        List<AboutUsEntity> aUsEntity = aboutUsRepository.findAll();
        List<AboutUsVO> aUsList = new LinkedList<>();

        for (AboutUsEntity aEntity : aUsEntity) {
            AboutUsVO aboutVO = new AboutUsVO();
            AboutUsMapper.convertAboutUsVOtoAboutUsEntity(aboutVO, aEntity);
            aUsList.add(aboutVO);
        }
        aboutUsResponse.setAboutUsVO(aUsList);
        aboutUsResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        aboutUsResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);

        return aboutUsResponse;
    }


    public AboutUsResponse addAboutUS(AboutUSRequest aboutUSRequest) {
        AboutUsResponse aboutUsResponse = new AboutUsResponse();
        AboutUsEntity aboutUsEntity = new AboutUsEntity();
        AboutUsMapper.convertAboutUsEnitytoAboutUsVO(aboutUSRequest.getAboutUsVO(), aboutUsEntity);
        aboutUsRepository.save(aboutUsEntity);


        aboutUsResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        aboutUsResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return aboutUsResponse;
    }
}
