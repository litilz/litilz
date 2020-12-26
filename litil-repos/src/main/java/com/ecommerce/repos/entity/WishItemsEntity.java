package com.ecommerce.repos.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wish_items")
public class WishItemsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;


    @JoinColumn(name = "productid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductEntity productid;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductEntity getProductid() {
        return productid;
    }

    public void setProductid(ProductEntity productid) {
        this.productid = productid;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "WishItemsEntity{" +
                "id=" + id +
                ", productid=" + productid +
                ", user_id=" + user_id +
                '}';
    }
}
