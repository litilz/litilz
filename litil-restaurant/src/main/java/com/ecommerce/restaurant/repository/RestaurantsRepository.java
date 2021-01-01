package com.ecommerce.restaurant.repository;

import com.ecommerce.restaurant.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<RestaurantsEntity, Integer> {

    @Query("SELECT r FROM RestaurantsEntity r WHERE  r.name = :name")
    RestaurantsEntity findRestaurant(String name);

}
