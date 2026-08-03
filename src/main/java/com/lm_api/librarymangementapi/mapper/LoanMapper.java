package com.lm_api.librarymangementapi.mapper;

import com.lm_api.librarymangementapi.dto.LoanResponse;
import com.lm_api.librarymangementapi.entities.BookEntity;
import com.lm_api.librarymangementapi.entities.LoanEntity;
import com.lm_api.librarymangementapi.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public LoanResponse transformToLoanResponse(LoanEntity loanEntity){
        return new LoanResponse(
                loanEntity.getId(),
                loanEntity.getUser().getId(),
                loanEntity.getBook().getId(),
                loanEntity.getBorrowDate(),
                loanEntity.getReturnDate()
        );
    }

    public LoanEntity transformToLoanEntity(UserEntity user, BookEntity book){
        return  LoanEntity.builder().user(user).book(book).build();
    }
}
