package iq.threed.webshop.service;

import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProduct(final Long productId) {
        return productRepository.findById(productId);
    }

    public ProductEntity createProduct(final ProductEntity inputProductEntity) {
        return productRepository.save(inputProductEntity);
    }

    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }
}
