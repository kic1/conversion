package com.example.conversion.api.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ParsingService {
	
	public String getHtmlByUrl(String url) throws IOException {
		
		Document doc = Jsoup.connect(url).get();
		return doc.html();
	}
}
