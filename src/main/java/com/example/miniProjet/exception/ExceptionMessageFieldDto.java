package com.example.miniProjet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessageFieldDto {
    private String object;
    private String field;
    private String message;
    private Object rejectedValue;

}
