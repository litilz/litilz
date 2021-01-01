package com.ecommerce.restaurant.service;

import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.repository.ItemsRepository;
import com.ecommerce.restaurant.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    RestaurantsRepository restaurantsRepository;

    public List<ItemsEntity> getItems() {
        return itemsRepository.findAll();
    }

}
