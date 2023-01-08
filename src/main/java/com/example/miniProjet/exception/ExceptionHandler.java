package com.example.miniProjet.exception;

import com.example.miniProjet.mapper.ExceptionMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private final ExceptionMessageMapper exceptionMessageMapper;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {


        System.out.print("\nex.getBindingResult().getFieldErrors().isEmpty()\n" +ex.getBindingResult().getFieldErrors().isEmpty());
        if(!ex.getBindingResult().getFieldErrors().isEmpty()){
            System.out.print("\nPass Fireld\n" +ex.getBindingResult().getFieldErrors().isEmpty());

            List<ExceptionMessageFieldDto> list = ex.getBindingResult().getFieldErrors().stream()
                    .map(exceptionMessageMapper::exceptionMessageFieldErrorToDto)
                    .collect(Collectors.toList());
            ErrorResponceField responce = new ErrorResponceField(status.toString(), status.value(), list);

            return new ResponseEntity<>(responce, status);
        } else {
            System.out.print("\n not Pass Fireld\n" +ex.getBindingResult().getFieldErrors().isEmpty());

           List<ExceptionMessageObjectDto> list = ex.getBindingResult().getAllErrors().stream()
                    .map(exceptionMessageMapper::exceptionMessageObjectToDto)
                    .collect(Collectors.toList());

            ErrorResponceObjectError responce = new ErrorResponceObjectError(status.toString(), status.value(), list);

            return new ResponseEntity<>(responce, status);
        }

    }
}
