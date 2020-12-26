package com.ecommerce.repos.entity;


import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "pincode")
@Transactional
public class PincodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;


    @Basic(optional = false)
    @Column(name = "pincode")
    private String pincode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
