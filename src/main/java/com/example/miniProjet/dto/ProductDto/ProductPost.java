package com.example.miniProjet.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
