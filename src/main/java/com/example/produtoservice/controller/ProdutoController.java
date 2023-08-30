package com.example.produtoservice.controller;

import com.example.produtoservice.model.ProdutoRequest;
import com.example.produtoservice.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;
    @PostMapping
    public ResponseEntity<Long> addProduto(@RequestBody ProdutoRequest produtoRequest){
        Long produtoId = produtoService.addProduto(produtoRequest);

        return new ResponseEntity<>(produtoId, HttpStatus.CREATED);
    }

}
