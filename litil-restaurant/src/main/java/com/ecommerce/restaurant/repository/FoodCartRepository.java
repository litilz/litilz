package com.ecommerce.restaurant.repository;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.restaurant.entity.FoodCartEntity;
import com.ecommerce.restaurant.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface FoodCartRepository extends JpaRepository<FoodCartEntity, Integer> {

    @Query("SELECT c FROM FoodCartEntity c WHERE c.user_id = :user_id")
    List<FoodCartEntity> findCart(UserEntity user_id);


    @Query("SELECT c FROM FoodCartEntity c WHERE c.user_id = :user_id and c.item_id = :item_id")
    FoodCartEntity findItem(ItemsEntity item_id, UserEntity user_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update FoodCartEntity c set c.quantity = c.quantity-1 WHERE c.id = :id")
    void decrement(Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update FoodCartEntity c set c.quantity = c.quantity+1 WHERE c.user_id = :user_id and c.item_id = :item_id")
    void increment(@Param("user_id") UserEntity user_id,@Param("item_id") ItemsEntity item_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM FoodCartEntity c WHERE  c.user_id = :user_id")
    void clearCart(@Param("user_id") UserEntity user_id);
}
