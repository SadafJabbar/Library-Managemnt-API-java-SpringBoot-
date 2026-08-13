package com.lm_api.librarymangementapi.service;

import com.lm_api.librarymangementapi.dto.CategoryRequest;
import com.lm_api.librarymangementapi.entities.CategoryEntity;
import com.lm_api.librarymangementapi.exceptions.CategoryNotFoundException;
import com.lm_api.librarymangementapi.repository.BookRepository;
import com.lm_api.librarymangementapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,BookRepository bookRepository){
        this.categoryRepository=categoryRepository;
        this.bookRepository=bookRepository;
    }

    public CategoryEntity getCategoryById(Long id){
         CategoryEntity category= categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
         return category;
            }



    public Page<CategoryEntity> getAllCategories(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }


    public CategoryEntity categoryCreation(CategoryRequest categoryRequest){
         CategoryEntity category=CategoryEntity.builder().
                name(categoryRequest.name())
                .book_count(0L).build();
         return categoryRepository.save(category);
    }


    public CategoryEntity categoryUpdation(Long id,CategoryRequest categoryRequest){
        CategoryEntity category=categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
        category.setName(categoryRequest.name());
        return categoryRepository.save(category);
    }


    public CategoryEntity categoryDeletion(Long id){
        CategoryEntity category=categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
        if(bookRepository.countByCategoryId(id)>0){
                throw  new IllegalStateException("Category cannot be deleted because it still contains books.");
            }
        categoryRepository.deleteById(id);
        return category;
    }

}
