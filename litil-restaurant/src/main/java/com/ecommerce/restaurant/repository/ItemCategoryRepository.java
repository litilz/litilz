package com.ecommerce.restaurant.repository;

import com.ecommerce.repos.entity.CategoryEntity;
import com.ecommerce.restaurant.entity.ItemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity,Integer> {
}
