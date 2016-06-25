package com.sungjun.news.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	
	public List<Map<String, String>> findNewsMainPage (String type) {
		
		List<Map<String, String>> resultList	= new ArrayList<Map<String, String>>();
		Map<String, String>	resultMap			= null;
		String url = null;
		
		// type 설정
		if ( "sisa".equals(type) ) {
			url = "http://news.nate.com/rank/interest?sc=sisa";
			
		} else if ( "sports".equals(type) ) {
			url = "http://news.nate.com/rank/interest?sc=spo";
			
		} else if ( "entertainment".equals(type) ) {
			url = "http://news.nate.com/rank/interest?sc=ent";
			
		} else {
			url = "http://news.nate.com/rank/interest?sc=all";
		}
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			/**
			 * [1] 1~5위 기사 처리 
			 */
			// 1~5 위 기사
			Elements topRankArticle	= doc.select("#contentsWraper .postRankSubjectList .mlt01 a");
			Elements topRankCpName	= doc.select("#contentsWraper .postRankSubjectList .mlt01 .medium");
			
			// 1~5위 기사 정보
			for (Element element : topRankArticle) {
				resultMap = new HashMap<String, String>();
				resultMap.put("title", element.select(".tb strong").text());
				resultMap.put("contents", element.select(".tb").get(0).ownText());
				resultMap.put("imageUrl", element.select(".mediatype img").attr("src").replaceAll("http://thumbnews.nateimg.co.kr/news90/", ""));
				resultMap.put("link", element.select("a").attr("href"));
				resultList.add(resultMap);
				resultMap = null;
			}
			
			// 1~5위 기사 기타 정보
			int n = 0;
			for (Element element : topRankCpName) {
				resultList.get(n).put("cpName", element.ownText());
				resultList.get(n).put("receiveDate", element.select("em").text());
				
				n++;
			}
			
			/**
			 * [2] 6~30위 기사처리
			 */
			Elements otherRankArticle	= doc.select("#contentsWraper .postRankSubject li a");
			Elements otherRankCpName	= doc.select("#contentsWraper .postRankSubject li .medium");
			
			// 6~30위 기사 정보
			for (Element element : otherRankArticle) {
				resultMap = new HashMap<String, String>();
				resultMap.put("link", element.attr("href"));
				resultMap.put("title", element.ownText());
				resultList.add(resultMap);
				resultMap = null;
			}
			
			// 6~30위 기사 매체사 정보
			n = 5;
			for (Element element : otherRankCpName) {
				resultMap = new HashMap<String, String>();
				resultList.get(n).put("cpName", element.ownText());
				
				n++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
}
