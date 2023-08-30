package com.example.produtoservice.controller;

import com.example.produtoservice.model.ProdutoRequest;
import com.example.produtoservice.model.ProdutoResponse;
import com.example.produtoservice.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getProdutoById(@PathVariable("id") Long produtoId){
        ProdutoResponse produtoResponse
                = produtoService.getProdutoById(produtoId);

        return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
    }

}
