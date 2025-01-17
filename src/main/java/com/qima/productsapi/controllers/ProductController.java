package com.qima.productsapi.controllers;

import com.qima.productsapi.ProductService;
import com.qima.productsapi.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }
}
