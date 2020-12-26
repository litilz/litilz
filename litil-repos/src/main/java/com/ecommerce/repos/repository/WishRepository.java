package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.ProductEntity;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.entity.WishItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WishRepository extends JpaRepository<WishItemsEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM WishItemsEntity w WHERE w.productid = :productId AND w.user_id = :user_id")
    void deleteWishListByUserIdAndProductId(@Param("user_id") UserEntity user_id,
                                            @Param("productId") ProductEntity productId);


    @Query("SELECT productid FROM WishItemsEntity w WHERE w.user_id = :user_id")
    List<ProductEntity> getUserIdsByUserNames(@Param("user_id") UserEntity user_id);
}
