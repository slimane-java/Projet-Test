package com.example.miniProjet.Api;

import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.Service.ProductService;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;
import com.example.miniProjet.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/create")
    public ResponseEntity<ProductGetDto> create(@RequestBody ProductPost productPost) {

        return new ResponseEntity<>(productService.add(productPost), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductGetDto>> all() {

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
}
