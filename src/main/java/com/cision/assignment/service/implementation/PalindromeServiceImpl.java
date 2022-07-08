package com.cision.assignment.service.implementation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cision.assignment.model.entity.Palindrome;
import com.cision.assignment.model.request.PalindromeRequest;
import com.cision.assignment.repository.PalindromeRepository;
import com.cision.assignment.service.PalindromeService;
import com.cision.assignment.util.ObjectMapperUtils;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	/**
	 * Regex to match all non-letter character.
	 */
	private static final String NON_LETTER_REG = "[^A-Za-z]+";
	
	private final PalindromeRepository palindromeRepository;

	public PalindromeServiceImpl(PalindromeRepository palindromeRepository) {
		this.palindromeRepository = palindromeRepository;
	}

	@Override
	public Palindrome save(@Valid PalindromeRequest palindromeRequest) {
		Palindrome palindromeToSave = toEntity(palindromeRequest);
		return palindromeRepository.save(palindromeToSave);
	}
	
	@Override
	public List<Palindrome> findAll() {
		return palindromeRepository.findAll();
	}

	/**
	 * Convert PalindromeRequest to Palindrome entity.
	 * Calculates size of longest palindrome string or substring of the content.
	 * @param palindromeRequest request
	 * @return palindrome entity.
	 */
	private Palindrome toEntity(@Valid PalindromeRequest palindromeRequest) {
		Palindrome palindrome = ObjectMapperUtils.map(palindromeRequest, Palindrome.class);
		palindrome.setLongestPalindromeSize(getLongestPalindrome(palindrome.getContent()));
		return palindrome;
	}

	/**
	 * Determines the size of the longest palindrome substring of the 
	 * input string.
	 * @param str
	 * @return size of the longest palindrome
	 */
	private int getLongestPalindrome(String str) {
		// Ignore all characters apart from letters.
		String alphabetString  = str.replaceAll(NON_LETTER_REG, "");
		int rank = alphabetString.length();
		while (rank != 1) {
			if (isNthRankContainsPalindrome(alphabetString, rank)) {
				return rank;
			}
			-- rank;
		}
		return rank;
	}

	/**
	 * This helper function determines if any of the n-th
	 * rank substring is a palindrome. 
	 * @param str 
	 * @param rank current substring rank level.
	 * @return true - if the rank has any palindromes
	 * 		   false - else 
	 */
	private boolean isNthRankContainsPalindrome(String str, int rank) { 
		for (int i = 0; i < rank; i++) {
			if (isPalindrome(str.substring(i, rank))) {
				 return true;
			}
			
			if (rank == str.length()) { 
				break;
			}
			
			++ rank;
		}
		return false;
		
	}

	/**
	 * Determines if given string is palindrome or not.
	 * @param str input string
	 * @return true - if palindrome
	 * 		   false - else
	 */
	private boolean isPalindrome(String str) {
		if (str == null) {
			return false;
		}
		
		String reverse = new StringBuilder(str).reverse().toString();
		return reverse.equals(str);
	}
}
