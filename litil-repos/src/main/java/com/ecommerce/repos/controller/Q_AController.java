package com.ecommerce.repos.controller;


import com.ecommerce.repos.entity.Q_AEntity;
import com.ecommerce.repos.repository.Q_ARepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Q_AController {

    @Autowired
    Q_ARepository Q_ARepository;

    @GetMapping(value = "getQ_A")
    public List<Q_AEntity> getQ_A(){
        return Q_ARepository.findAll();
    }
}
