package com.ecommerce.restaurant.repository;


import com.ecommerce.restaurant.entity.RestaurantCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategoriesEntity, Integer> {
}
