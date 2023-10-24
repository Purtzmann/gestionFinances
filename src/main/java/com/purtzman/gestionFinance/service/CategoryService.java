package com.purtzman.gestionFinance.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purtzman.gestionFinance.model.Category;
import com.purtzman.gestionFinance.repository.CategoryRepository;

@Service
public class CategoryService {

   @Autowired
   private CategoryRepository categoryRepository;

   @PostConstruct
   public void initDefaultCategories() {
       if (categoryRepository.count() == 0) {
           String[] defaultCategories = { "Nourriture", "Transport", "Logement", "Loisirs" };
           for (String name : defaultCategories) {
               Category category = new Category();
               category.setName(name);
               category.setPredefined(true); // Setting predefined to true for default categories
               categoryRepository.save(category);
           }
       }
   }
   

   public List<Category> getAllCategories() {
      return categoryRepository.findAll();
   }

   public Category createCategory(Category category) {
      return categoryRepository.save(category);
   }

   public void deleteCategory(Long id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);

    if (!optionalCategory.isPresent()) {
        throw new EntityNotFoundException("Category not found.");
    }

    Category category = optionalCategory.get();

    if (category.isPredefined()) {
        throw new IllegalArgumentException("Cannot delete a predefined category.");
    }

    categoryRepository.delete(category);
}


}
