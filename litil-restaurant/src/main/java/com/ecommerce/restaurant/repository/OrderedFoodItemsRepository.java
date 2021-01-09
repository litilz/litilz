package com.ecommerce.restaurant.repository;

import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import com.ecommerce.restaurant.entity.OrderedFoodItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderedFoodItemsRepository extends JpaRepository<OrderedFoodItemsEntity, Integer> {


    @Query("SELECT o FROM OrderedFoodItemsEntity o WHERE o.order_id = :order_id")
    List<OrderedFoodItemsEntity> findByOrderId(FoodOrdersEntity order_id);

}
