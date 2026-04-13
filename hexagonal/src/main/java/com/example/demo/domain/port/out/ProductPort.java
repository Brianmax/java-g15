package com.example.demo.domain.port.out;

import com.example.demo.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPort {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);
}
