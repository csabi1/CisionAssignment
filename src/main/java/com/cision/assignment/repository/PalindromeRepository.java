package com.cision.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cision.assignment.model.entity.Palindrome;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome, Long> {

}
