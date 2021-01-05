package com.ecommerce.litil.repository;

import com.ecommerce.repos.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface CategoryRepository extends JpaRepository <CategoryEntity, Integer> {

    @Query("SELECT ce FROM CategoryEntity ce")
    List <CategoryEntity> findAllCategory();

}
