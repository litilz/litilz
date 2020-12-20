package com.ecommerce.litil.repository;

import com.ecommerce.litil.entity.OrdersEntity;
import com.ecommerce.litil.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {


    @Query("SELECT o FROM OrdersEntity o WHERE o.user_id = :user_id")
    List<OrdersEntity> findAllUserOrders(UserEntity user_id);
}
