package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.MediaOrderEntity;
import com.ecommerce.repos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaOrderRepository extends JpaRepository<MediaOrderEntity, Integer> {

    @Query("SELECT m FROM MediaOrderEntity m WHERE m.user_id = :user_id")
    List<MediaOrderEntity> findAllUserOrders(UserEntity user_id);
}
