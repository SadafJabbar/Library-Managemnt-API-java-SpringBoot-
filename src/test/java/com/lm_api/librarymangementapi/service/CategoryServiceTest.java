package com.lm_api.librarymangementapi.service;


import com.lm_api.librarymangementapi.dto.CategoryRequest;
import com.lm_api.librarymangementapi.entities.CategoryEntity;
import com.lm_api.librarymangementapi.repository.BookRepository;
import com.lm_api.librarymangementapi.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    public static final String NAME="Programming";
    public static final Long C_Id=4L;
    public static final Long COUNT=9L;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void method_should_return_category_entity(){
        CategoryRequest categoryRequest= CategoryRequest.builder().name(NAME).build();

        CategoryEntity savedCategory=CategoryEntity.builder().
                id(C_Id).name(NAME).book_count(COUNT).build();

        when(categoryRepository.save(any(CategoryEntity.class)))
                .thenReturn(savedCategory);
        CategoryEntity actualCategory=categoryService.categoryCreation(categoryRequest);

        assertAll(()-> assertEquals(NAME,actualCategory.getName()),
                ()-> assertEquals(COUNT,actualCategory.getBook_count()),
                ()-> assertEquals(C_Id,actualCategory.getId()));

        verify(categoryRepository)
                .save(any(CategoryEntity.class));    }

}