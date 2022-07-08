package com.cision.assignment.model.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "palindrome")
public class Palindrome implements Serializable{
	
	private static final long serialVersionUID = 3270176823593762693L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String content;
	
	private OffsetDateTime timestamp;
	
	private Integer longestPalindromeSize;


}
