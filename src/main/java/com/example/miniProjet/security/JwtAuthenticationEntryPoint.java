package com.example.miniProjet.security;

import com.example.miniProjet.enums.ExceptionEnum;
import com.example.miniProjet.exception.AuthorisedExceptionHandler;
import com.example.miniProjet.exception.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private ObjectMapper object = new ObjectMapper();
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {


        System.out.print("Unauthorized/n"+ authException.getMessage());
        ErrorMessage error = new ErrorMessage();
        error.setMessage(ExceptionEnum.UNAUTHORIZED.toString());
        error.setStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
        error.setTimesTamp(new Date());
        error.setDescription("should to sign in again your toket was exspered");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println(object.writeValueAsString(error));

        //throw new AuthorisedExceptionHandler("you need to sing in");
    }
}
