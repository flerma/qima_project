package com.qima.productsapi.controller;

import com.qima.productsapi.dto.ProductDto;
import com.qima.productsapi.service.CategoryService;
import com.qima.productsapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/product")
public class ProductViewController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String viewProducts(Model model) {

        model.addAttribute("products", productService.getAll());

        return "products";
    }

    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new ProductDto());
        model.addAttribute("categories", categoryService.getAll());
        return "create-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") ProductDto productDTO) {
        productService.save(productDTO);
        return "redirect:/view/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteById(id);
        return "redirect:/view/product";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam("id") Long id, Model model) {
        ProductDto product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        return "edit-product";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") ProductDto productDTO) {
        productService.update(productDTO);
        return "redirect:/view/product";
    }
}