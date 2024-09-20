package com.blogging.bloging.service;

import com.blogging.bloging.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(Long categoryId);

    Category updateCategory(Category category, Long categoryId);

    void deleteCategory(Long categoryId);


}
