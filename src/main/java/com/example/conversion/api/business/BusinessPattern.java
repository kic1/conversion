package com.example.conversion.api.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BusinessPattern {

	DOES_NOT_CONTAIN_NUMBERS("[^0-9]"),
	DOES_NOT_CONTAIN_ALPHABETS("[^a-zA-Z]"),
	HTML_TAG("<.*?>");
	
	@Getter
	private String regex;
}
