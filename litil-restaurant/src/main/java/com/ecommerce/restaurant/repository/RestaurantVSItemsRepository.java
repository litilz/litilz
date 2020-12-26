package com.ecommerce.restaurant.repository;

import com.ecommerce.restaurant.entity.Restaurant_vs_itemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantVSItemsRepository extends JpaRepository<Restaurant_vs_itemsEntity, Integer> {
    
}
