package com.ecommerce.restaurant.repository;


import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrdersRepository extends JpaRepository<FoodOrdersEntity,Double> {

    @Query("SELECT o FROM OrdersEntity o WHERE o.user_id = :user_id")
    List<FoodOrdersEntity> findByUser(UserEntity user_id);
}
