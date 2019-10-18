package com.example.conversion.api.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.example.conversion.engine.exception.GoneException;

@Service
public class ParsingService {
	
	public String getContents(String url) {
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new GoneException();
		}
		return doc.html();
	}
}
