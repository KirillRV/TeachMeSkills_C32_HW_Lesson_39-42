package com.tms.controller;

import com.tms.model.Product;
import com.tms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String getProductCreatePage(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @GetMapping("/update/{id}")
    public String getProductUpdatePage(@PathVariable Long id, Model model) {
        return productService.getProductById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "editProduct";
                })
                .orElse("error");
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "createProduct";
        }
        return productService.createProduct(product)
                .map(p -> {
                    model.addAttribute("product", p);
                    return "product";
                })
                .orElse("error");
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        return productService.getProductById(id)
                .map(product -> {
                    model.addAttribute("product", product);
                    return "product";
                })
                .orElse("error");
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "editProduct";
        }
        return productService.updateProduct(product)
                .map(p -> {
                    model.addAttribute("product", p);
                    return "product";
                })
                .orElse("error");
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        if (productService.deleteProduct(id)) {
            return "redirect:/";
        } else {
            model.addAttribute("message", "Product not deleted.");
            return "error";
        }
    }
}