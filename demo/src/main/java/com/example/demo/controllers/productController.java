package com.example.demo.controllers;

import com.example.demo.Reposetory.Product;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public List<Product> getProduct(){
        return service.getList();
    }

    @PostMapping("/")
    public List<Product> postProduct(Product product){
        service.setList(product);
        return service.getList();
    }

    @PutMapping("/")
    public List<Product> updateProduct(Product product){
        service.updateList(product);
        return service.getList();
    }

    @DeleteMapping("/")
    public List<Product> deleteProduct(Product product){
        service.delete(product);
        return service.getList();
    }
}
