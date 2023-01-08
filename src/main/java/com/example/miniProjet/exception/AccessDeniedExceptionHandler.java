package com.example.miniProjet.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AccessDeniedExceptionHandler implements AccessDeniedHandler {
    private ObjectMapper object = new ObjectMapper();
    private Gson gson = new Gson();


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorMessage error = new ErrorMessage();

        error.setDescription("you need the access");
        error.setStatusCode(status.value());
        error.setMessage("you need the access");
        error.setTimesTamp(new Date());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        response.getOutputStream()
                .println(
                        //object.writeValueAsString(error)
                        gson.toJson(error)
                );
    }
}
