package com.example.conversion.engine.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.conversion.engine.util.FilterNumberUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilterNumberUtilTest {
	
	private final String source = "01A9a2Bz";
	
	@Test
	public void t01_filterOnlyNumber() {
		assertEquals("0192", FilterNumberUtil.getOnlyNumber(source));
	}
}
