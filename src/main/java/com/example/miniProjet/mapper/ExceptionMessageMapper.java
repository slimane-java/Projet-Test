package com.example.miniProjet.mapper;

import com.example.miniProjet.exception.ExceptionMessageFieldDto;
import com.example.miniProjet.exception.ExceptionMessageObjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Mapper(
        componentModel = "spring"
)
public interface ExceptionMessageMapper {
    @Mapping(target = "object", source = "objectName")
    @Mapping(target = "field", source = "field")
    @Mapping(target = "message", source = "defaultMessage")
    @Mapping(target = "rejectedValue", source = "rejectedValue")
    ExceptionMessageFieldDto exceptionMessageFieldErrorToDto(FieldError fieldError);

    @Mapping(target = "object", source = "objectName")
    @Mapping(target = "message", source = "defaultMessage")
    ExceptionMessageObjectDto exceptionMessageObjectToDto(ObjectError error);
}
