package com.purtzman.gestionFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.purtzman.gestionFinance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
   
}
