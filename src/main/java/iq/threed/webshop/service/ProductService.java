package iq.threed.webshop.service;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.CategoryEntity;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.repository.CategoryRepository;
import iq.threed.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(final ProductRepository productRepository, final CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> getProducts() {
        return createProductFromENtity();
    }

    public Optional<ProductEntity> getProduct(final Long productId) {
        return productRepository.findById(productId);
    }

    public ProductEntity saveProduct(final ProductEntity inputProductEntity) {
        return productRepository.save(inputProductEntity);
    }

    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }

    private List<ProductDto> createProductFromENtity() {
        final List<ProductEntity> products = productRepository.findAll();
        final List<ProductDto> productsDtos = new ArrayList<>();
        for (ProductEntity product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setCode(product.getCode());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(product.getQuantity());
            productDto.setDescription(product.getDescription());
            productDto.setCategoryId(product.getCategoryId());
            Optional<CategoryEntity> categoryName = categoryRepository.findById(product.getCategoryId());
            productDto.setCategory(categoryName.get().getName());
            productsDtos.add(productDto);
        }
        return productsDtos;
    }
}
