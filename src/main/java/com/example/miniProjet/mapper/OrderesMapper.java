package com.example.miniProjet.mapper;

import com.example.miniProjet.Entity.OrdersEntity;
import com.example.miniProjet.dto.orders.OrdersGetDto;
import com.example.miniProjet.dto.orders.OrdersPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderesMapper {

    @Mapping(target = "idOrder", source = "id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "client.id", source = "client.id")
    OrdersGetDto ordersEntityToDtoGet(OrdersEntity ordersEntity);
    @Mapping(target = "id", source = "idOrder")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "client.id", source = "client.id")
    OrdersEntity ordersDtoToEntityPost(OrdersPostDto ordersPostDto);

    List<OrdersGetDto> listOrdersEntityToDto(List<OrdersEntity> ordersEntities);

}
