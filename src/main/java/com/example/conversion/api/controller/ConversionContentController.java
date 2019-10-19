package com.example.conversion.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conversion.api.form.RequestForm;
import com.example.conversion.api.form.ResponseForm;
import com.example.conversion.api.service.ConversionContentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags="conversion APIs")
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ConversionContentController {
	
	private final ConversionContentService conversionContentService;
	
	@ApiOperation(
			value="conversion", 
			notes="ex) /api/conversion?filterCondition=INCLUDE_ALL_TEXT&splitUnitAmount=5&targetUrl=https://okky.kr/article/639505",
			response=ResponseForm.class
	)
	@GetMapping("/conversion")
	public ResponseForm getResult(@Valid RequestForm requestForm){
		return conversionContentService.getResult(requestForm);
	}
}
