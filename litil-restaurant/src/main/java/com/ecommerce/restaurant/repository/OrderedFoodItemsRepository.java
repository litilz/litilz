package com.ecommerce.restaurant.repository;

import com.ecommerce.restaurant.entity.OrderedFoodItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedFoodItemsRepository extends JpaRepository<OrderedFoodItemsEntity,Integer> {
}
