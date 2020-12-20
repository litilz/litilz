package com.ecommerce.litil.vo;

public class WishVO {

    private Boolean wishFlag;
    private String user_name;
    private int productId;

    public Boolean getWishFlag() {
        return wishFlag;
    }

    public void setWishFlag(Boolean wishFlag) {
        this.wishFlag = wishFlag;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "WishVO{" +
                "wishFlag=" + wishFlag +
                ", user_name='" + user_name + '\'' +
                ", productId=" + productId +
                '}';
    }
}
