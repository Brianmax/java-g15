package com.example.demo.infrastructure.in.web;

import com.example.demo.domain.model.Product;
import com.example.demo.domain.port.in.ProductUseCase;
import com.example.demo.infrastructure.in.web.dto.ProductRequest;
import com.example.demo.infrastructure.in.web.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        Product product = toDomain(request);
        Product created = productUseCase.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.from(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = productUseCase.findById(id);
        return ResponseEntity.ok(ProductResponse.from(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> products = productUseCase.findAll().stream()
                .map(ProductResponse::from)
                .toList();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product product = toDomain(request);
        Product updated = productUseCase.update(id, product);
        return ResponseEntity.ok(ProductResponse.from(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Product toDomain(ProductRequest request) {
        return new Product(null, request.name(), request.description(), request.price(), request.stock());
    }
}
