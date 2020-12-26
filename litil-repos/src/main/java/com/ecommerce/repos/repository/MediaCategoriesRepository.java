package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.MediaCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaCategoriesRepository extends JpaRepository<MediaCategoriesEntity, Integer> {

    @Query("SELECT m FROM MediaCategoriesEntity m WHERE m.category = :category")
    MediaCategoriesEntity findImage(String category);
}
