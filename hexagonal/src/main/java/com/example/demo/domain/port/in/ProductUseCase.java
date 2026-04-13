package com.example.demo.domain.port.in;

import com.example.demo.domain.model.Product;

import java.util.List;

public interface ProductUseCase {

    Product create(Product product);

    Product findById(Long id);

    List<Product> findAll();

    Product update(Long id, Product product);

    void delete(Long id);
}
