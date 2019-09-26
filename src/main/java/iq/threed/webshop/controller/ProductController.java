package iq.threed.webshop.controller;

import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<ProductEntity> getProduct(final @PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public ProductEntity createProduct(final @RequestBody ProductEntity inputProductEntity) {
        return productService.createProduct(inputProductEntity);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(final @PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.accepted().build();
    }
}
