package com.example.conversion.api.util;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MergeUtilTest {
	
	@Test
	public void t1_mergeText() {
		
		final String sourceAlphabet = "AAaaBbb";
		final String sourceNumber = "0012";
		final String expectedMergedText = "A0A0a1a2Bbb";
		
		assertEquals(expectedMergedText, MergeUtil.mergeText(sourceAlphabet, sourceNumber));
	}
}
