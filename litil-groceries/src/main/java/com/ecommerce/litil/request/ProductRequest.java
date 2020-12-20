package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.ProductVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequest {

    @JsonProperty("data")
    private ProductVO productVO;

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

}
