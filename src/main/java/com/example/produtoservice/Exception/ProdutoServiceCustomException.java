package com.example.produtoservice.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ProdutoServiceCustomException extends RuntimeException {

    private String errorCode;
    public ProdutoServiceCustomException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
