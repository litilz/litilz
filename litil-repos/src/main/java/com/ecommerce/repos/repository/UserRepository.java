package com.ecommerce.repos.repository;

import com.ecommerce.repos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    @Query("SELECT u FROM UserEntity u WHERE u.user_name = :user_name")
    UserEntity findByUserId(@Param("user_name") String user_name);

    @Query("SELECT u FROM UserEntity u WHERE u.phone = :phone")
    UserEntity getUserByPhoneNumber(@Param("phone") String phone);


}
