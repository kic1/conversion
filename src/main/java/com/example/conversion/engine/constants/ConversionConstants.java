package com.example.conversion.engine.constants;

import java.math.BigInteger;

import com.example.conversion.api.business.FilterCondition;

public class ConversionConstants {
	public final static String          SAMPLE_PARSING_URL              = "https://okky.kr/article/639505";
	public final static String          SAMPLE_INVALID_URL              = "http://INVAILD.URL";
	public final static FilterCondition SAMPLE_FILTER_CONDITION         = FilterCondition.EXCLUDE_HTML_TAG;
	public final static String          SAMPLE_FILTER_CONDITION_STRING  = SAMPLE_FILTER_CONDITION.toString();
	public final static BigInteger      SAMPLE_SPLIT_UNIT_AMOUNT        = BigInteger.valueOf(5);
	public final static String          SAMPLE_SPLIT_UNIT_AMOUNT_STRING = String.valueOf(SAMPLE_SPLIT_UNIT_AMOUNT);
	public final static String          SAMPLE_EXPECTED_QUOTIENT_TEXT   = "A1B2C3";
	public final static String          SAMPLE_EXPECTED_REMAIN_TEXT     = "ZZ";
}
