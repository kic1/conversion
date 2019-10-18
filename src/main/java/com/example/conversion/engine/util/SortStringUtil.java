package com.example.conversion.engine.util;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

public class SortStringUtil {
	
    public static String getOrderedText(String source, Comparator<String> pattern){
    	
        String[] sortedArray = source.split(StringUtils.EMPTY);
        Arrays.sort(sortedArray, pattern);
        
        return String.join(StringUtils.EMPTY, sortedArray);
    }
}
