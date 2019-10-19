package com.example.conversion.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ConversionWebController {
	
	@GetMapping(value = {"", "/conversion/form"})
	public String getConversionForm() {
		return "conversion";
	}
}
