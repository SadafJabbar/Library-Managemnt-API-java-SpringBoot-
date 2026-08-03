package com.lm_api.librarymangementapi.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("category with id" + id + " is not found");
    }
}
