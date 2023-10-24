package com.purtzman.gestionFinance.service;

import java.util.List;

import javax.annotation.PostConstruct;

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

}
