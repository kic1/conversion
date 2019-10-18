package com.example.conversion.api.business;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.conversion.api.business.MergeText;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MergeTextTest {
	
	@Test
	public void t01_mergeText() {
		
		final String sourceAlphabet     = "AAaaBbb";
		final String sourceNumber       = "0012";
		final String expectedMergedText = "A0A0a1a2Bbb";
		
		assertEquals(expectedMergedText, MergeText.mergeText(sourceAlphabet, sourceNumber));
	}
}
