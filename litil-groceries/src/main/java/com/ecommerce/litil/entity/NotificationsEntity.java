package com.ecommerce.litil.entity;


import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "notifications")
@Transactional
public class NotificationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;


    @Basic(optional = false)
    @Column(name = "notification")
    private String notification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
