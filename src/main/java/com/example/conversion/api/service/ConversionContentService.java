package com.example.conversion.api.service;

import org.springframework.stereotype.Service;

import com.example.conversion.api.form.RequestForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConversionContentService {
	
	private final ParsingContentService parsingContentService;
	
	public Object getResult(RequestForm requestForm) {
		log.debug("*** requestForm : " +requestForm.toString());
		return null;
	}
}
