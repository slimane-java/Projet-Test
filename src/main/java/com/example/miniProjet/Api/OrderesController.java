package com.example.miniProjet.Api;

import com.example.miniProjet.Entity.OrdersEntity;
import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.Service.OrdersService;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;
import com.example.miniProjet.dto.orders.OrdersGetDto;
import com.example.miniProjet.dto.orders.OrdersPostDto;
import com.example.miniProjet.mapper.OrderesMapper;
import com.example.miniProjet.validateInterface.OnCreateOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Validated

public class OrderesController {

    private final OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<OrdersGetDto> create(@Validated(OnCreateOrder.class) @RequestBody OrdersPostDto ordersPostDto) {

        OrdersGetDto order = ordersService.create(ordersPostDto);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getOve")
    public ResponseEntity<List<OrdersGetDto>> getOver() {
         List<OrdersGetDto> result = new ArrayList<>();

        List<OrdersGetDto> list = ordersService.getAll();

        list.stream().forEach(ordersGetDto -> {

            List<ProductGetDto> products = ordersGetDto.getProducts();

            List<ProductGetDto> productsGreaterThan100 = products.stream()
                    .filter(productPost -> productPost.getPrice() >= 100)
                    .collect(Collectors.toList());

            ordersGetDto.setProducts(productsGreaterThan100);

            result.add(ordersGetDto);
        });

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdersGetDto>> all() {

        return new ResponseEntity<>(ordersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/deleteProducte/{idProd}/{idOrder}")
    public ResponseEntity<String> deleteProducte(@PathVariable("idOrder") Long idOrder, @PathVariable("idProd") Long idProd) {

        ordersService.deleteProduct(idProd, idOrder);
        return new ResponseEntity<>("product deleted", HttpStatus.OK);
    }
}
