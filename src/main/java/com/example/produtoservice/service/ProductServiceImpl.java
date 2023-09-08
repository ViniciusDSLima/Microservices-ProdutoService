package com.example.produtoservice.service;

import com.example.produtoservice.Exception.ProdutoServiceCustomException;
import com.example.produtoservice.entity.Product;
import com.example.produtoservice.model.ProductRequest;
import com.example.produtoservice.model.ProductResponse;
import com.example.produtoservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@AllArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public Long addProduto(ProductRequest productRequest) {
        log.info("Adiciona um produto ao banco de dados");

        Product product =
                Product.builder()
                        .name(productRequest.getName())
                        .quantity(productRequest.getQuantity())
                        .price(productRequest.getPrice())
                        .build();

        productRepository.save(product);

        log.info("produto criado");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProdutoById(Long productId) {
        log.info("Buscando produto com o id informado");
        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new ProdutoServiceCustomException("Nao ha produto com esse id", "Produto not found"));

        ProductResponse productResponse
                = new ProductResponse();

        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, int quantity) {
        log.info("Reduce quantitty {} for id: {}", quantity, productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProdutoServiceCustomException(
                "Product with given id not found", "PRODUCT_NOT_FOUND"));

        if(product.getQuantity() <  quantity){
            throw new ProdutoServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product quantity updated successfully");
    }
}
