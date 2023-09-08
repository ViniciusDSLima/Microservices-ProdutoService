package com.example.produtoservice.controller;

import com.example.produtoservice.model.ProductRequest;
import com.example.produtoservice.model.ProductResponse;
import com.example.produtoservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProdutoController {

    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> addProduto(@RequestBody ProductRequest productRequest){
        Long produtoId = productService.addProduto(productRequest);

        return new ResponseEntity<>(produtoId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProdutoById(@PathVariable("id") Long productId){
        ProductResponse productResponse
                = productService.getProdutoById(productId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity reduceQuantity(@PathVariable("id") Long productId, @RequestParam int quantity){

        productService.reduceQuantity(productId, quantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
