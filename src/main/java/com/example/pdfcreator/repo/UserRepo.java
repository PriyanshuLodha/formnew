package com.example.pdfcreator.repo;

import com.example.pdfcreator.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {


    UserEntity findByPassword(String password);
    UserEntity findByEmail(String email);
}