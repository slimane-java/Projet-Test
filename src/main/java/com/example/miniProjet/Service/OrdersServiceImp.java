package com.example.miniProjet.Service;

import com.example.miniProjet.Entity.OrdersEntity;
import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.dao.ClientRepository;
import com.example.miniProjet.dao.OrdersRepository;
import com.example.miniProjet.dao.ProductRepository;
import com.example.miniProjet.dto.orders.OrdersGetDto;
import com.example.miniProjet.dto.orders.OrdersPostDto;
import com.example.miniProjet.mapper.OrderesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrdersServiceImp implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderesMapper orderesMapper;

    @Override
    public OrdersGetDto create(OrdersPostDto ordersPostDto) {
        OrdersEntity ordersEntity = orderesMapper.ordersDtoToEntityPost(ordersPostDto);
        OrdersEntity order = ordersRepository.save(ordersEntity);
        order.setClient(clientRepository.findById(ordersPostDto.getClient().getId()).orElse(null));

         List<ProductEntity> product = order.getProducts()
                .stream()
                .map(e ->  productRepository.findById(e.getId()).orElse(null))
                .collect(Collectors.toList());
         order.setProducts(product);

        return orderesMapper.ordersEntityToDtoGet(order);
    }

    @Override
    public List<OrdersGetDto> getAll() {
        return orderesMapper.listOrdersEntityToDto(ordersRepository.findAll());
    }

    @Override
    public List<OrdersGetDto> getOver(float price) {
        return orderesMapper.listOrdersEntityToDto(ordersRepository.getOver(price));
    }

    @Override
    @Transactional
    public void deleteProduct(Long idProduct, Long idOrder) {
        ordersRepository.deleteProduct(idProduct, idOrder);
    }
}
