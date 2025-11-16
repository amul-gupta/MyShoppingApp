package com.example.MyShoppingApp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        ApiResponseMessage responseMessage=  ApiResponseMessage.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST)
                .status(false)
        .build();

        return new ResponseEntity<>(responseMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseMessage> handleResourceNotFoundException(Exception ex)
    {
        ApiResponseMessage responseMessage=  ApiResponseMessage.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST)
                .status(false)
                .build();

        return new ResponseEntity<>(responseMessage,HttpStatus.BAD_REQUEST);
    }
}
