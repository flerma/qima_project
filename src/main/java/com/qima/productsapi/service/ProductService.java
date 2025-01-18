package com.qima.productsapi.service;

import com.qima.productsapi.dto.ProductDto;
import com.qima.productsapi.entity.Category;
import com.qima.productsapi.entity.Product;
import com.qima.productsapi.repository.CategoryRepository;
import com.qima.productsapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

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
                .categoryId(product.getCategory() != null
                    ? product.getCategory().getId()
                    : null
                )
                .categoryPath(
                    product.getCategory() != null
                        ? product.getCategory().getCategoryPath()
                        : null
                )
                .build()
            )
            .toList();
    }

    public void save(ProductDto productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        Product product = Product.builder()
            .name(productDTO.getName())
            .description(productDTO.getDescription())
            .price(productDTO.getPrice())
            .available(productDTO.getAvailable())
            .obsolete(productDTO.getObsolete())
            .yearCreation(productDTO.getYearCreation())
            .serialNumber(productDTO.getSerialNumber())
            .category(category)
            .build();

        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto getById(Long id) {
        return productRepository.findById(id)
            .map(product ->
                ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .available(product.getAvailable())
                .obsolete(product.getObsolete())
                .yearCreation(product.getYearCreation())
                .serialNumber(product.getSerialNumber())
                .categoryId(product.getCategory().getId())
                .categoryPath(product.getCategory().getCategoryPath())
                .build())
            .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
    }

    public void update(ProductDto productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        Product product = productRepository.findById(productDTO.getId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setAvailable(productDTO.getAvailable());
        product.setYearCreation(productDTO.getYearCreation());
        product.setSerialNumber(productDTO.getSerialNumber());
        product.setCategory(category);

        productRepository.save(product);
    }
}
