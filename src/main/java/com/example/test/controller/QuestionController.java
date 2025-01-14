package com.example.test.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Question;
import com.example.test.service.QuestionService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")	
	public List<Question> getAllQuestions() {
		
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
		
	}
	
	@Transactional
	@DeleteMapping("/deleteCategory/{category}")
	public String deleteByCategory(@PathVariable String category) {
		
		questionService.deleteByCategory(category);
		return "Success";
	}
}
