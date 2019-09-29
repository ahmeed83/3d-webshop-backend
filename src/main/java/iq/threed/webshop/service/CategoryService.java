package iq.threed.webshop.service;

import iq.threed.webshop.entity.CategoryEntity;
import iq.threed.webshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity saveCategory(final CategoryEntity inputCategoryEntity) {
        return categoryRepository.save(inputCategoryEntity);
    }
}
