package iq.threed.webshop.controller;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.CategoryEntity;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.service.CategoryService;
import iq.threed.webshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(final ProductService productService, final CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<ProductEntity> getProduct(final @PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public ProductEntity createProduct(final @RequestBody ProductEntity inputProductEntity) {
        return productService.saveProduct(inputProductEntity);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(final @PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/categories")
    public List<CategoryEntity> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/add-category")
    public CategoryEntity saveCategory(final @RequestBody CategoryEntity inputCategoryEntity) {
        return categoryService.saveCategory(inputCategoryEntity);
    }
}
