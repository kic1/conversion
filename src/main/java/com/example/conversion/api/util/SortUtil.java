package com.example.conversion.api.util;

import java.util.Arrays;
import java.util.Comparator;

public class SortUtil {
	
    public static String getOrderedText(String source, Comparator<String> pattern){
    	
        String[] sortedArray = source.split("");
        Arrays.sort(sortedArray, pattern);
        
        return String.join("", sortedArray);
    }
    
    public static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
    	public int compare(String str1, String str2) {
    		int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
    		if (res == 0) {
    			res = str1.compareTo(str2);
    		}
    		return res;
    	}
    };
    
    public static Comparator<String> NUMERICAL_ORDER = new Comparator<String>() {
    	public int compare(String str1, String str2) {
    		return Integer.parseInt(str1) - Integer.parseInt(str2);
    	}
    };
}
