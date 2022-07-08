package com.cision.assignment.model.request;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PalindromeRequest {
	
	@NotEmpty
	@NotNull
	private String content;

	@NotNull
	private OffsetDateTime timestamp;
}
