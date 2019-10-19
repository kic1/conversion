package com.example.conversion.api.form;

import java.math.BigInteger;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import com.example.conversion.api.business.FilterCondition;
import com.example.conversion.engine.constants.ConversionConstants;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestForm {
	
	@ApiParam(required=true, name="targetUrl", value="대상 URL", defaultValue=ConversionConstants.SAMPLE_PARSING_URL)
	@URL
    private String targetUrl;
	
	@ApiParam(required=true, name="filterCondition", value="HTML 태그 제외(EXCLUDE_HTML_TAG) || Text 전체(INCLUDE_ALL_TEXT)", defaultValue="EXCLUDE_HTML_TAG")
    private FilterCondition filterCondition;
	
	@ApiParam(required=true, name="splitUnitAmount", value="출력묶음단위(자연수)", defaultValue="5")
    @Positive
    private BigInteger splitUnitAmount;
}
