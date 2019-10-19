package com.example.conversion.api.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseForm {
	
	@ApiModelProperty(value="몫")
    private String quotientText;
	@ApiModelProperty(value="나머지")
    private String remainText;
}
