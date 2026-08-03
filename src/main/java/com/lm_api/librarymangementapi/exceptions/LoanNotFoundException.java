package com.lm_api.librarymangementapi.exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(Long id) {
        super("Loan with id:" +id+ "is not found");
    }
}
