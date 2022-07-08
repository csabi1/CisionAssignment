package com.cision.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cision.assignment.model.entity.Palindrome;
import com.cision.assignment.model.request.PalindromeRequest;
import com.cision.assignment.service.PalindromeService;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {
	
	private final PalindromeService palindromeService;
	
	public PalindromeController(PalindromeService palindromeService) {
		this.palindromeService = palindromeService;
	}
	
	@PostMapping("/save")
	public Palindrome save(@RequestBody @Valid PalindromeRequest request) {
		return palindromeService.save(request);
	}
	
	@GetMapping("/find-all")
	public List<Palindrome> findAll() { 
		return palindromeService.findAll();
	}
}
