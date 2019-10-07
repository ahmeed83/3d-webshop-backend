package iq.threed.webshop.service;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.CategoryEntity;
import iq.threed.webshop.entity.ProductEntity;
import iq.threed.webshop.mapper.ProductMapper;
import iq.threed.webshop.repository.CategoryRepository;
import iq.threed.webshop.repository.ProductRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Product service.
 */
@Service
@ConfigurationProperties(prefix = "uploaded.image")
public class ProductService {

    /**
     * Logger.
     */
    private final Logger logger = Logger.getLogger(ProductService.class.getName());

    /**
     * Product Repository.
     */
    private final ProductRepository productRepository;

    /**
     * Image Properties.
     */
    private String imageDir;

    /**
     * Category Repository.
     */
    private CategoryRepository categoryRepository;

    /**
     * Constructor.
     *
     * @param productRepositoryVal productRepository
     * @param categoryRepository   categoryRepository
     */
    public ProductService(
            final ProductRepository productRepositoryVal,
            final CategoryRepository categoryRepository) {
        this.productRepository = productRepositoryVal;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Setter to get the image address from the server.
     *
     * @param imageDir imageDir
     */
    public void setImageDir(final String imageDir) {
        this.imageDir = imageDir;
    }

    /**
     * get all products.
     *
     * @return all products from the db
     */
    public final List<ProductDto> getProducts() {
        return mapListProductFromListEntity();
    }

    /**
     * Get one products.
     *
     * @param productId productId
     * @return one prodcut from the db
     */
    public final ProductDto getProduct(final Long productId) {
        return ProductMapper.MAPPER.toProductDto(productRepository.findById(productId).orElse(null));
    }

    /**
     * Save one product.
     *
     * @param productDto productDto
     * @param image      image
     */
    public final void saveProduct(final ProductDto productDto, final MultipartFile image) {
        byte[] bytes;
        try {
            bytes = image.getBytes();
            Path path = Paths.get(imageDir + productDto.getImageName());
            Files.write(path, bytes);
        } catch (IOException e) {
            //TODO: add proper exception handling
            logger.warning("Image can't be saved to the file system");
        }
        productRepository.save(ProductMapper.MAPPER.toProductEntity(productDto));
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
    private List<ProductDto> mapListProductFromListEntity() {
        final List<ProductEntity> products = productRepository.findAll();
        final List<ProductDto> productsDtos = new ArrayList<>();

        products.forEach(product -> {
            final ProductDto productDto = ProductMapper.MAPPER.toProductDto(product);
            Optional<CategoryEntity> categoryName = categoryRepository.findById(product.getCategoryId());
            //TODO: take care of the getName method
            productDto.setCategoryName(categoryName.orElse(null).getName());
            productsDtos.add(productDto);
        });
        return productsDtos;
    }
}
