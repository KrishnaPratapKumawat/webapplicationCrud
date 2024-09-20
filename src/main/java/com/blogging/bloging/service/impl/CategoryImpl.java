package com.blogging.bloging.service.impl;

import com.blogging.bloging.model.Category;
import com.blogging.bloging.repo.CategoryRepo;
import com.blogging.bloging.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public Category createCategory(Category category) {
        Category save = this.categoryRepo.save(category);
        return save;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryRepoAll = this.categoryRepo.findAll();
        return categoryRepoAll;
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow();
        return category;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category category1 = this.categoryRepo.findById(categoryId).orElseThrow();
        category1.setCategoryTitle(category.getCategoryTitle());
        Category save = this.categoryRepo.save(category1);
        return save;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow();
        this.categoryRepo.delete(category);
    }
}
