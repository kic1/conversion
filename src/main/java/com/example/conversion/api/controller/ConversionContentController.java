package com.example.conversion.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conversion.api.form.RequestForm;
import com.example.conversion.api.form.ResponseForm;
import com.example.conversion.api.service.ConversionContentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ConversionContentController {
	
	private final ConversionContentService conversionContentService;
	
	@GetMapping("/conversion")
	public ResponseForm getResult(@Valid RequestForm requestForm){
		return conversionContentService.getResult(requestForm);
	}
}
