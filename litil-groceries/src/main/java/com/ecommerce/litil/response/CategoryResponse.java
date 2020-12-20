package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.CategoryVO;

import java.util.List;

public class CategoryResponse extends BaseResponse {

    List<CategoryVO> categories;

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }
}
