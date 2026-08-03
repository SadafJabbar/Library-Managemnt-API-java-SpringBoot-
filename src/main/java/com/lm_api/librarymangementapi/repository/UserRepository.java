package com.lm_api.librarymangementapi.repository;

import com.lm_api.librarymangementapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByNameContainingIgnoreCase(String name);
}
