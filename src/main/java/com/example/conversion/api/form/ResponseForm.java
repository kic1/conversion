package com.example.conversion.api.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseForm {
	
    private String quotientText;
    private String remainText;
}
