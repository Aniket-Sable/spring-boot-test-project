package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
