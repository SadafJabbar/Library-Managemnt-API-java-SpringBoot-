package com.lm_api.librarymangementapi.repository;

import com.lm_api.librarymangementapi.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
