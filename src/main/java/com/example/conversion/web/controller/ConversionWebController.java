package com.example.conversion.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ConversionWebController {
	
	public final static String VIEW_CONVERSION_FORM_PAGE = "conversion";
	
	@GetMapping(value = {"", "/conversion/form"})
	public String getConversionForm() {
		return VIEW_CONVERSION_FORM_PAGE;
	}
}
