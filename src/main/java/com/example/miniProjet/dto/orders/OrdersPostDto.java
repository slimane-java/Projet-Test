package com.example.miniProjet.dto.orders;

import com.example.miniProjet.customAnnotation.CheckClient1;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.validateInterface.OnCreateOrder;
import lombok.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersPostDto {


    private Long idOrder;
    @NotNull(groups = OnCreateOrder.class, message = "put the correct date")
    private Date orderDate;
    @Valid
    @CheckClient1(groups = OnCreateOrder.class)
    private ClientGetDto client;
    @Valid
    private List<ProductGetDto> products;
}
