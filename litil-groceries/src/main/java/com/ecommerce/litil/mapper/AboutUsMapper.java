package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.AboutUsEntity;
import com.ecommerce.litil.entity.HelpSupportEntity;
import com.ecommerce.litil.vo.AboutUsVO;
import com.ecommerce.litil.vo.HelpSupportVO;
import org.springframework.beans.BeanUtils;

public class AboutUsMapper {

    public static void convertAboutUsEnitytoAboutUsVO(AboutUsVO aboutVO, AboutUsEntity aboutEntity) {

        BeanUtils.copyProperties(aboutVO, aboutEntity);
    }

    public static void convertAboutUsVOtoAboutUsEntity(AboutUsVO aboutVO, AboutUsEntity aboutEntity) {

        BeanUtils.copyProperties(aboutEntity, aboutVO);
    }

    public static void convertHelpSupportVOtoHelpSupportEntity(HelpSupportVO hsVO, HelpSupportEntity hEntity) {

        BeanUtils.copyProperties(hsVO, hEntity);
    }

    public static void convertHelpSupportEntitytoHelpSupportVO(HelpSupportVO hsVO, HelpSupportEntity hEntity) {

        BeanUtils.copyProperties(hEntity, hsVO);
    }
}
