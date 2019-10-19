package com.example.conversion.api.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BusinessPattern {

	DOES_NOT_CONTAIN_NUMBER  ("[^0-9]"),
	DOES_NOT_CONTAIN_ALPHABET("[^a-zA-Z]"),
	HTML_TAGS                ("<.*?>");
	
	@Getter
	private String regex;
}
