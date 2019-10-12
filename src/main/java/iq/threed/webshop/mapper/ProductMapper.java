package iq.threed.webshop.mapper;

import iq.threed.webshop.dto.ProductDto;
import iq.threed.webshop.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Product mapper.
 */
@Mapper
public interface ProductMapper {

    /**
     * Mapper instance.
     */
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    /**
     * Maps product entity to DTO.
     *
     * @param productEntity productEntity
     * @return productDto
     */
    @Mapping(target = "categoryName", source = "name")
    ProductDto toProductDto(ProductEntity productEntity);

    /**
     * Maps product DTO to entity.
     *
     * @param productDto productDto
     * @return productEntity
     */
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ProductEntity toProductEntity(ProductDto productDto);
}
