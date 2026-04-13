package com.example.demo.application.service;

import com.example.demo.domain.exception.ProductNotFoundException;
import com.example.demo.domain.model.Product;
import com.example.demo.domain.port.in.ProductUseCase;
import com.example.demo.domain.port.out.ProductPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements ProductUseCase {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public Product create(Product product) {
        return productPort.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productPort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productPort.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        if (!productPort.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        product.setId(id);
        return productPort.save(product);
    }

    @Override
    public void delete(Long id) {
        if (!productPort.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productPort.deleteById(id);
    }
}
