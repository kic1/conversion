package com.example.conversion.engine.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilterAlphabetUtilTest {
	
	private final String source = "01A9a2Bz";
	
	@Test
	public void t01_filterOnlyAlphabet() {
		assertEquals("AaBz", FilterAlphabetUtil.getOnlyAlphabet(source));
	}
}
