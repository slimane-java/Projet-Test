package com.example.miniProjet.dao;

import com.example.miniProjet.Entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    @Query("select o from OrdersEntity o JOIN ProductEntity  p where p.price > :price")
    List<OrdersEntity> getOver(@Param("price")float price);

    @Modifying
    @Query(value = "delete from order_product op where op.product_id = :idProduct and  op.order_id  = :idOrder", nativeQuery = true)
    void deleteProduct(@Param("idProduct") Long idProduct, @Param("idOrder") Long idOrder ) ;
}
