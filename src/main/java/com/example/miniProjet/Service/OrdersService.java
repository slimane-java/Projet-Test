package com.example.miniProjet.Service;

import com.example.miniProjet.Entity.OrdersEntity;
import com.example.miniProjet.dto.orders.OrdersGetDto;
import com.example.miniProjet.dto.orders.OrdersPostDto;

import java.util.List;

public interface OrdersService {
    OrdersGetDto create(OrdersPostDto ordersPostDto);
    List<OrdersGetDto> getAll();
    List<OrdersGetDto>getOver(float price );

    void deleteProduct(Long idProduct, Long idOrder);
}
