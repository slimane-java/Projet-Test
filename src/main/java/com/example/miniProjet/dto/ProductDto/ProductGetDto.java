package com.example.miniProjet.dto.ProductDto;

import com.example.miniProjet.validateInterface.OnCreateOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetDto {
    @NotNull(groups = OnCreateOrder.class)
    private Long id;
    private String name;
    private float price;
}
