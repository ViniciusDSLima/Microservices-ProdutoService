package com.example.produtoservice.service;

import com.example.produtoservice.entity.Produto;
import com.example.produtoservice.model.ProdutoRequest;
import com.example.produtoservice.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class ProdutoServiceImpl implements ProdutoService{

    private ProdutoRepository produtoRepository;
    @Override
    public Long addProduto(ProdutoRequest produtoRequest) {
        log.info("Adiciona um produto ao banco de dados");

        Produto produto =
                Produto.builder()
                        .nome(produtoRequest.getNome())
                        .quantidade(produtoRequest.getQuantidade())
                        .preco(produtoRequest.getPreco())
                        .build();

        produtoRepository.save(produto);

        log.info("produto criado");
        return produto.getProdutoId();
    }
}
