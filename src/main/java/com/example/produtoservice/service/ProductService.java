package com.example.produtoservice.service;

import com.example.produtoservice.model.ProductRequest;
import com.example.produtoservice.model.ProductResponse;

public interface ProductService {
    Long addProduto(ProductRequest productRequest);

    ProductResponse getProdutoById(Long productId);

    void reduceQuantity(Long productId, int quantity);
}
