package com.example.MyShoppingApp.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseMessage {

    private String message;
    private HttpStatus code;
    private boolean status;
}
