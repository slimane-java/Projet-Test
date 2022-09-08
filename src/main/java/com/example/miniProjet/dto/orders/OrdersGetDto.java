package com.example.miniProjet.dto.orders;

import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ClientPostDto;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersGetDto {
    private Long idOrder;
    private Date orderDate;
    private ClientGetDto client;
    private List<ProductGetDto> products;
}
