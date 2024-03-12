package com.example.demo.global.jwt;

import com.example.demo.global.handler.ErrorResponse;
import com.example.demo.global.handler.exception.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.info("Unauthorized Error");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper mapper = new ObjectMapper(); //code, message
        String result = mapper.writeValueAsString(ErrorResponse.of(
                ErrorCode.HANDLE_ACCESS_DENIED,
                "Access is denied",
                ErrorCode.HANDLE_ACCESS_DENIED.getStatus()
        ));
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }
}