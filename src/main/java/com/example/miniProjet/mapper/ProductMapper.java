package com.example.miniProjet.mapper;

import com.example.miniProjet.Entity.ProductEntity;
import com.example.miniProjet.classValidation.ValidatePrice;
import com.example.miniProjet.dto.ProductDto.ProductGetDto;
import com.example.miniProjet.dto.ProductDto.ProductPost;
import com.example.miniProjet.exception.ValidatePriceExceptionHandler;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = {ValidatePrice.class},componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "name", source = "nameProduct")
    @Mapping(target = "price", source = "priceProduct", defaultValue = "0"/*, qualifiedByName = "overThen"*/)
    @Mapping(target = "ref", source = "refProduct")
    ProductEntity productDtoToEntityPost(ProductPost productPost) throws ValidatePriceExceptionHandler;

    /*@Mapping(target = "nameProduct", source = "name")
    @Mapping(target = "priceProduct", source = "price", defaultValue = "0")*/
    ProductGetDto productEntityToDtoGet(ProductEntity productEntity);

    ProductEntity productEntityToDtoGet(ProductPost productPost);

    List<ProductGetDto> listProductEntityToDto(List<ProductEntity> list);

    @Named("overThen")
    public static float overThen(float price) {
        return  price * 100;
    }
}
