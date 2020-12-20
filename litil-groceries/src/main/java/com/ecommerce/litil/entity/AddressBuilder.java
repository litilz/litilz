package com.ecommerce.litil.entity;

public class AddressBuilder {

    private int id;
    private String name;
    private String line1;
    private Boolean active;
    private Boolean enabled;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String landmark;
    private String mobile;
    private UserEntity user_id;


    public AddressBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AddressBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AddressBuilder setUser_id(UserEntity user_id) {
        this.user_id = user_id;
        return this;
    }

    public AddressBuilder setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public AddressBuilder setLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public AddressBuilder setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public AddressBuilder setLandmark(String landmark) {
        this.landmark = landmark;
        return this;
    }

    public AddressBuilder setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public AddressEntity getAddressEntity() {
        return new AddressEntity(id, name, line1, Boolean.TRUE, city, state, country, pincode, landmark, mobile,user_id,enabled);
    }

}
