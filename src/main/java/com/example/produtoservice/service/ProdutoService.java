package com.example.produtoservice.service;

import com.example.produtoservice.model.ProdutoRequest;

public interface ProdutoService {
    Long addProduto(ProdutoRequest produtoRequest);
}
