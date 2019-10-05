package iq.threed.webshop.service;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Product service.
 */
@Service
public class ProductService {

    /**
     * Model Mapper.
     */
    private final ModelMapper modelMapper;
    /**
     * Product Repository.
     */
    private final ProductRepository productRepository;

    /**
     * Constructor.
     *
     * @param productRepositoryVal productRepository
     * @param modelMapperVal       modelMapper
     */
    public ProductService(final ProductRepository productRepositoryVal, final ModelMapper modelMapperVal) {
        this.productRepository = productRepositoryVal;
        this.modelMapper = modelMapperVal;
    }

    /**
     * get all products.
     *
     * @return all prodcuts from the db
     */
    public final List<ProductDto> getProducts() {
        return createProductFromEntity();
    }

    /**
     * Get one products.
     *
     * @param productId productId
     * @return one prodcut from the db
     */
    public final Optional<ProductEntity> getProduct(final Long productId) {
        return productRepository.findById(productId);
    }

    /**
     * Save one product.
     *
     * @param productDto productDto
     */
    public final void saveProduct(final ProductDto productDto) {
        final ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productEntity.setCreatedAt(LocalDateTime.now());
        productRepository.save(modelMapper.map(productDto, ProductEntity.class));
    }

    /**
     * Delete one product.
     *
     * @param productId productId
     */
    public final void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Create a Product DTO from product entities.
     *
     * @return productsDtos
     */
    private List<ProductDto> createProductFromEntity() {
        final List<ProductEntity> products = productRepository.findAll();
        final List<ProductDto> productsDtos = new ArrayList<>();

        products.forEach(product -> {
            ProductDto productDto = ProductDto.builder()
                    .imageName(product.getImageName()).code(product.getCode()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).description(product.getDescription())
                    .categoryId(product.getCategoryId()).build();

//            Optional<CategoryEntity> categoryName = categoryRepository.findById(product.getCategoryId());
//            productDto.setCategory(categoryName.get().getName());
            productsDtos.add(productDto);
        });
        return productsDtos;
    }
}
