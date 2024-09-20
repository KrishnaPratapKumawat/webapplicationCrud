package com.blogging.bloging.controller;

import com.blogging.bloging.model.Category;
import com.blogging.bloging.service.impl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryImpl category;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category category1 = this.category.createCategory(category);
        return new ResponseEntity(category1, HttpStatus.CREATED);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> allCategory = this.category.getAllCategory();
        return new ResponseEntity<>(allCategory,HttpStatus.OK);
    }
    @GetMapping("/getCategoryId/{categoryId}")
    public ResponseEntity<Category> getCategoryId(@PathVariable Long categoryId){
        Category categoryById = this.category.getCategoryById(categoryId);
        return new ResponseEntity<>(categoryById, HttpStatus.OK);
    }
    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){
        Category category1 = this.category.updateCategory(category, categoryId);
        return new ResponseEntity<>(category1,HttpStatus.OK);
    }
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        this.category.deleteCategory(categoryId);
        return new ResponseEntity<>("Data is deleted",HttpStatus.OK);

    }
}
