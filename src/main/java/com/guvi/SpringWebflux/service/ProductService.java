package com.guvi.SpringWebflux.service;

import com.guvi.SpringWebflux.dto.MapperUtil;
import com.guvi.SpringWebflux.dto.ProductDTO;
import com.guvi.SpringWebflux.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Flux<ProductDTO> getProducts() {
        return productRepository.findAll().map(MapperUtil::toDTO);
    }


    public Mono<ProductDTO> getProduct(String id) {
        return productRepository.findById(id).map(MapperUtil::toDTO);
    }


    public Mono<ProductDTO> saveProduct(ProductDTO productDTO) {
        return productRepository.save(MapperUtil.toEntity(productDTO)).map(MapperUtil::toDTO);
    }


    public Mono<ProductDTO> updateProduct(String id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productDTO.getName());
                    existingProduct.setQuantity(productDTO.getQuantity());
                    existingProduct.setPrice(productDTO.getPrice());
                    return productRepository.save(existingProduct);
                })
                .map(MapperUtil::toDTO);
    }


    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}

