package com.ecommerce.repos.repository;


import com.ecommerce.repos.entity.CartEntity;
import com.ecommerce.repos.entity.ProductEntity;
import com.ecommerce.repos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {


    @Query("SELECT c FROM CartEntity c WHERE c.productid = :productid and c.user_id = :user_id")
    CartEntity find(@Param("user_id") UserEntity user_id, @Param("productid") ProductEntity productid);

    @Transactional
    @Modifying
    @Query("update CartEntity c set c.quantity = c.quantity+1 where c.user_id = :user_id and c.productid = :productid")
    void increment(@Param("user_id") UserEntity user_id, @Param("productid") ProductEntity productid);

    @Transactional
    @Modifying
    @Query("update CartEntity c set c.quantity = c.quantity-1 where c.user_id = :user_id and c.productid = :productid")
    void decrement(@Param("user_id") UserEntity user_id, @Param("productid") ProductEntity productid);

    @Query("SELECT c FROM CartEntity c WHERE  c.user_id = :user_id")
    List<CartEntity> findAll(@Param("user_id") UserEntity user_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM CartEntity c WHERE  c.user_id = :user_id")
    void deleteById(@Param("user_id") UserEntity user_id);
}
