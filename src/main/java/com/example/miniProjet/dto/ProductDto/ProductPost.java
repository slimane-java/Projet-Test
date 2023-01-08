package com.example.miniProjet.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPost {

    private Long id;
    @NotBlank
    private String nameProduct;
    @NotBlank
    @Min(value = 10)
    private float priceProduct;
    @NotBlank
    private String refProduct;
}
