package com.lm_api.librarymangementapi.service;

import com.lm_api.librarymangementapi.dto.BookRequest;
import com.lm_api.librarymangementapi.dto.BookResponse;
import com.lm_api.librarymangementapi.entities.BookEntity;
import com.lm_api.librarymangementapi.entities.CategoryEntity;
import com.lm_api.librarymangementapi.mapper.BookMapper;
import com.lm_api.librarymangementapi.repository.BookRepository;
import com.lm_api.librarymangementapi.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    public static final String TITLE= "Resolution";
    public  static final String AUTHOR="William gray";
    public static final int STOCK= 10;
    public static final Long YEAR=1990L;
    public static final Long C_ID=3L;
    public static final Long book_ID=9L;
    public  static final String STATUS="Available";
    public  static final String C_NAME="Programming";


    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper bookMapper;
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    public void Test_should_return_BookResponse(){
        BookRequest bookRequest=BookRequest.builder().
                title(TITLE).author(AUTHOR).stock(STOCK).publishedYear(YEAR).categoryId(C_ID).build();

        CategoryEntity categoryEntity= CategoryEntity.builder().id(C_ID)
                .name(C_NAME).book_count(10L).build();

        BookEntity bookEntity= BookEntity.builder().
        id(book_ID).title(TITLE).author(AUTHOR).
                status(STATUS).publishedYear(YEAR).
                stock(STOCK).category(categoryEntity).build();

        BookResponse expectedResponse= BookResponse.builder().id(book_ID)
                .title(TITLE).author(AUTHOR).status(STATUS).
                publishedYear(YEAR).stock(STOCK).category(categoryEntity).build();

        when(categoryRepository.findById(C_ID)).thenReturn(Optional.of(categoryEntity));
        when(bookMapper.transformToBookEntity(bookRequest)).thenReturn(bookEntity);
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
        when(bookRepository.countByCategoryId(C_ID)).thenReturn(1L);
        when(bookMapper.transformToBookResponse(bookEntity)).thenReturn(expectedResponse);

        //act
        BookResponse actualResponse=bookService.bookCreation(bookRequest);
        //verify
        assertAll(
                ()-> assertEquals(TITLE,actualResponse.title()),
                ()-> assertEquals(AUTHOR,actualResponse.author()),
                ()-> assertEquals(STOCK,actualResponse.stock()),
                ()-> assertEquals(YEAR,actualResponse.publishedYear()));

    }
}
