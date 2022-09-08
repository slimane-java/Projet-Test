package com.example.miniProjet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponceField {
    private String error;
    private int code;
    private List<ExceptionMessageFieldDto> errors;
}
