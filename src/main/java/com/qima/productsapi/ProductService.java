package com.qima.productsapi;

import com.qima.productsapi.dto.ProductDto;
import com.qima.productsapi.entities.Product;
import com.qima.productsapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
            .map(product -> ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .available(product.getAvailable())
                .obsolete(product.getObsolete())
                .yearCreation(product.getYearCreation())
                .serialNumber(product.getSerialNumber())
                .categoryPath(
                    product.getCategory() != null
                        ? product.getCategory().getCategoryPath()
                        : null
                )
                .build()
            )
            .toList();
    }
}
