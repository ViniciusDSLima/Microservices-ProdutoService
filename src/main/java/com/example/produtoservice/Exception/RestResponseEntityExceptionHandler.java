package com.example.produtoservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProdutoServiceException(ProdutoServiceCustomException produtoServiceCustomException){
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(produtoServiceCustomException.getMessage())
                .errorCode(produtoServiceCustomException.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);

    }
}
