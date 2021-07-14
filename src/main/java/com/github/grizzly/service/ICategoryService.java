package com.github.grizzly.service;

import com.github.grizzly.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Optional<Category> findCategoryById(long id);

    Optional<Category> findCategoryByName(String name);

    List<Category> findCategoriesByParentId(Long parentId);

    List<Category> findCategoriesByParentIdIsNull();

    void save(Category category);

    Category update(Category category);

}
