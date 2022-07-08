package com.cision.assignment.service;

import java.util.List;

import javax.validation.Valid;

import com.cision.assignment.model.entity.Palindrome;
import com.cision.assignment.model.request.PalindromeRequest;

public interface PalindromeService {
	/**
	 * Palindrome save.
	 * @param palindromeRequest
	 * @return Palindrome entity.
	 */
	Palindrome save(@Valid PalindromeRequest palindromeRequest);

	/**
	 * Find all existing palindrome entity.
	 * @return list of palindromes.
	 */
	List<Palindrome> findAll();
}
