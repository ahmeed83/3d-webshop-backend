package iq.threed.webshop.controller;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.CategoryEntity;
import iq.threed.webshop.service.CategoryService;
import iq.threed.webshop.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Product controller.
 *
 * @author @Ahmed Aziz
 * @version 1.1
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /**
     * AtomicLong used to increment the image name.
     */
    private final AtomicLong atomicLong;
    /**
     * Product service.
     */
    private final ProductService productService;
    /**
     * Category service.
     */
    private final CategoryService categoryService;

    /**
     * Constructor.
     *
     * @param atomicLongVal      atomicLong
     * @param productServiceVal  productService
     * @param categoryServiceVal categoryService
     */
    public ProductController(final AtomicLong atomicLongVal,
                             final ProductService productServiceVal,
                             final CategoryService categoryServiceVal) {
        this.atomicLong = atomicLongVal;
        this.productService = productServiceVal;
        this.categoryService = categoryServiceVal;
    }

    /**
     * Rest call to get all products.
     *
     * @return all products.
     */
    @GetMapping
    public final List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    /**
     * Rest call to get one products by its ID.
     *
     * @param productId productId
     * @return ProductDto
     */
    @GetMapping("/{productId}")
    public final ProductDto getProduct(final @PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    /**
     * Rest call to post one products.
     *
     * @param image       image
     * @param code        code
     * @param name        name
     * @param description description
     * @param price       price
     * @param quantity    quantity
     * @param categoryId  categoryId
     */
    @PostMapping
    public final void createProduct(final @RequestParam("image") MultipartFile image,
                                    final @RequestParam("code") String code,
                                    final @RequestParam("name") String name,
                                    final @RequestParam("description") String description,
                                    final @RequestParam("price") String price,
                                    final @RequestParam("quantity") String quantity,
                                    final @RequestParam("categoryId") String categoryId) {
        String imageName = image.getOriginalFilename() + "-" + atomicLong.incrementAndGet();
        ProductDto productDto = ProductDto.builder().imageName(imageName).code(code)
                .name(name).price(Double.parseDouble(price)).quantity(Integer.parseInt(quantity))
                .description(description).categoryId(Long.valueOf(categoryId)).build();
        productService.saveProduct(productDto, image);
    }

    /**
     * Rest call to delete one products.
     *
     * @param productId productId
     */
    @DeleteMapping("/{productId}")
    public final void deleteProduct(final @PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    /**
     * Rest call to get all the categories.
     *
     * @return all categories
     */
    @GetMapping("/categories")
    public final List<CategoryEntity> getCategories() {
        return categoryService.getCategories();
    }

    /**
     * Rest call to add one category.
     */
    @PostMapping("/add-category")
    public final void saveCategory(final @RequestBody CategoryEntity inputCategoryEntity) {
        categoryService.saveCategory(inputCategoryEntity);
    }
}
