package com.example.produtoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoResponse {
    private String produtoNome;
    private Long produtoId;
    private int quantidade;
    private Long preco;
}
