package com.ecommerce.litil.entity;


import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "help_support")
@Transactional
public class HelpSupportEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    @Column(name = "category")
    private String category;

    @Basic(optional = false)
    @Column(name = "value")
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HelpSupportEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
