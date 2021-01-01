package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.ProductVO;
import com.ecommerce.repos.response.BaseResponse;

import java.util.List;

public class CartResponse extends BaseResponse {
    private List<ProductVO> productVO;

    public List<ProductVO> getProductVO() {
        return productVO;
    }

    public void setProductVO(List<ProductVO> productVO) {
        this.productVO = productVO;
    }
}
