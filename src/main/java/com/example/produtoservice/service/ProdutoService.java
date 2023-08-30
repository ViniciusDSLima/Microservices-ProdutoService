package com.example.produtoservice.service;

import com.example.produtoservice.model.ProdutoRequest;
import com.example.produtoservice.model.ProdutoResponse;

public interface ProdutoService {
    Long addProduto(ProdutoRequest produtoRequest);

    ProdutoResponse getProdutoById(Long produtoId);
}
