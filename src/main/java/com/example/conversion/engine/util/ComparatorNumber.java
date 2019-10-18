package com.example.conversion.engine.util;

import java.util.Comparator;

public class ComparatorNumber implements Comparator<String> {
	
	@Override
	public int compare(String str1, String str2) {
		return Integer.parseInt(str1) - Integer.parseInt(str2);
	}
}
