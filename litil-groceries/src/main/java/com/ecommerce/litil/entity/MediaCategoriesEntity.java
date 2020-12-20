package com.ecommerce.litil.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "media_categories")
public class MediaCategoriesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "category", nullable = false, length = 255)
    private String category;

    @Basic
    @Column(name = "image", nullable = false, length = 255)
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
