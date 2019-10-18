package com.example.conversion.api.form;

import java.math.BigInteger;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestForm {
	
	@URL
    private String url;
    private String filterCondition;
    @Positive
    private BigInteger splitUnitAmount;
}
