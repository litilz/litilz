package com.ecommerce.litil.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "selling", nullable = false, length = 255)
    private String selling;

    @Basic
    @Column(name = "availability", nullable = false, length = 255)
    private Boolean availability;

    @Basic
    @Column(name = "original", nullable = false, length = 255)
    private String original;
    @Basic
    @Column(name = "discount", nullable = false, length = 255)
    private String discount;
    @Basic
    @Column(name = "image", nullable = false, length = 255)
    private String image;
    @Basic
    @Column(name = "category", nullable = false, length = 255)
    private String category;
    @Basic
    @Column(name = "weight", nullable = false, length = 255)
    private String weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selling='" + selling + '\'' +
                ", availability=" + availability +
                ", original='" + original + '\'' +
                ", discount='" + discount + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
