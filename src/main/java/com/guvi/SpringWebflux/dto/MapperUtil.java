package com.guvi.SpringWebflux.dto;

import com.guvi.SpringWebflux.entity.Product;
import org.modelmapper.ModelMapper;


public class MapperUtil {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO toDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}

