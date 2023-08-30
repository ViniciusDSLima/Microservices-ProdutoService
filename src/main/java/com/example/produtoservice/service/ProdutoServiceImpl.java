package com.example.produtoservice.service;

import com.example.produtoservice.Exception.ProdutoServiceCustomException;
import com.example.produtoservice.entity.Produto;
import com.example.produtoservice.model.ProdutoRequest;
import com.example.produtoservice.model.ProdutoResponse;
import com.example.produtoservice.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

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

    @Override
    public ProdutoResponse getProdutoById(Long produtoId) {
        log.info("Buscando produto com o id informado");
        Produto produto
                = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ProdutoServiceCustomException("Nao ha produto com esse id", "Produto not found"));

        ProdutoResponse produtoResponse
                = new ProdutoResponse();

        copyProperties(produto, produtoResponse);

        return produtoResponse;
    }
}
