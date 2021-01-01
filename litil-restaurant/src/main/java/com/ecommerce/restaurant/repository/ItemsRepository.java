package com.ecommerce.restaurant.repository;

import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Integer> {


    @Query("SELECT r FROM ItemsEntity r WHERE  r.restaurant_id = :restaurant_id")
    List<ItemsEntity> findAll(RestaurantsEntity restaurant_id);
}
