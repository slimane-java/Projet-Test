package com.example.miniProjet.Service;

import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.dao.ProductRepository;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;
import com.example.miniProjet.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductGetDto add(ProductPost productPost) {
        ProductEntity product = productMapper.productDtoToEntityPost(productPost);
        return productMapper.productEntityToDtoGet(productRepository.save(product));
    }

    @Override
    public ProductGetDto update(ProductPost productPost) {
        ProductEntity product = productMapper.productDtoToEntityPost(productPost);
        return productMapper.productEntityToDtoGet(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        if(productRepository.findById(id).isPresent()){
            ProductEntity product = productRepository.findById(id).get();
            productRepository.delete(product);
        }

    }

    @Override
    public ProductGetDto getById(Long id) {
        return productMapper.productEntityToDtoGet(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<ProductGetDto> getAll() {
        return productMapper.listProductEntityToDto(productRepository.findAll());
    }
}
