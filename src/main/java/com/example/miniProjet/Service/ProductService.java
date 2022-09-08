package com.example.miniProjet.Service;

import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductGetDto add(ProductPost productPost);
    ProductGetDto update(ProductPost productPost);
    void delete(Long id);
    ProductGetDto getById(Long id);
    List<ProductGetDto> getAll();
}
