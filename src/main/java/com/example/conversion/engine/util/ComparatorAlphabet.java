package com.example.conversion.engine.util;

import java.util.Comparator;

public class ComparatorAlphabet implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		
		int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
		if (res == 0) {
			res = str1.compareTo(str2);
		}
		
		return res;
	}
}
