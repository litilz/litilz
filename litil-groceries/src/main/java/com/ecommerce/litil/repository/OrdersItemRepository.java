package com.ecommerce.litil.repository;

import com.ecommerce.litil.entity.OrderItemEntity;
import com.ecommerce.litil.entity.OrdersEntity;
import com.ecommerce.litil.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface OrdersItemRepository extends JpaRepository<OrderItemEntity, Long> {

//    @Query("SELECT product_id FROM OrderItemEntity o WHERE o.order_id = :order_id")
//    List<ProductEntity> getProductsByorderId(@Param("order_id") OrdersEntity order_id);

    @Query("SELECT o FROM OrderItemEntity o WHERE o.order_id = :order_id")
    List<OrderItemEntity> findAllProducts(@Param("order_id") OrdersEntity order_id);
}
