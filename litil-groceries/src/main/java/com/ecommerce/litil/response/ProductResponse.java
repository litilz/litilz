package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.ProductVO;

import java.util.List;

public class ProductResponse extends BaseResponse {

    private List<ProductVO> productList;


    public List<ProductVO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductVO> productList) {
        this.productList = productList;
    }


}
