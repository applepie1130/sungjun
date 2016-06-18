package com.sungjun.news.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sungjun.news.service.NewsAPIService;

@RestController
@RequestMapping("/api/news/")
public class NewsAPIController {
	
	@Autowired(required=false)
	NewsAPIService newsService;

	/**
	 * 오늘의 말씀
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/daily-qt",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Map<String, Object> getDailyQTData( @RequestParam(value="name", defaultValue="test") String name ) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/DailyQTMap.json");
		
		return newsService.getDailyQTData(paramMap);
	}
	
	/**
	 * 네이트 실시간 랭킹뉴스 - 시사
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/sisa-rank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getSisaRankingNewsList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NateRealRankNewsList_1.json");
		
		return newsService.getSisaRankingNewsList(paramMap);
	}
	
	/**
	 * 네이트 실시간 랭킹뉴스 - 연예
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/entertainment-rank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getEntertainmentRankingNewsList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NateRealRankNewsList_2.json");
		
		return newsService.getEntertainmentRankingNewsList(paramMap);
	}
	
	/**
	 * 네이트 실시간 랭킹뉴스 - 스포츠
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/sports-rank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getSportsRankingNewsList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NateRealRankNewsList_3.json");
		
		return newsService.getSportsRankingNewsList(paramMap);
	}
	
	
	/**
	 * 네이버 실시간 검색어
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/naver-realrank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getRealRankWithNaverList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NaverRealRankList.json");
		
		return newsService.getRealRankWithNaverList(paramMap);
	}
	
	
	/**
	 * 다음 실시간 검색어
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/daum-realrank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getRealRankWithDaumList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/DaumRealRankList.json");
		
		return newsService.getRealRankWithDaumList(paramMap);
	}
	
	/**
	 * 이 시각 상한가 종목 (코스피) 
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/finance-upper-kospi",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getKOSPIUpperList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NaverFinanceUpperList_KOSPI.json");
		
		return newsService.getKOSPIUpperList(paramMap);
	}
	
	/**
	 * 이 시각 상한가 종목 (코스닥) 
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/finance-upper-kosdaq",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getKOSDAQUpperList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NaverFinanceUpperList_KOSDAQ.json");
		
		return newsService.getKOSDAQUpperList(paramMap);
	}

	/**
	 * 증권 트랜드 랭킹 
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/finance-trendrank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Object> getFinanceTrendRankList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/NaverTrendRankList.json");
		
		return newsService.getFinanceTrendRankList(paramMap);
	}
	
	
	/**
	 * Crawling TEST
	 * 
	 * @return
	 */
	@RequestMapping(
			value="/crawling",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Map<String, String>> getCrawling() {
		
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		
		String url = "http://news.nate.com/rank/?mid=n1000";
		int rank;
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			
			/**
			 * [1] 1~5위 기사 처리 
			 */
			// 1~5 위 기사
			Elements topRankArticle = doc.select("#contentsWraper .postRankSubjectList .mlt01 a");
			Elements topRankCpName= doc.select("#contentsWraper .postRankSubjectList .mlt01 .medium");
			
			// 1~5위 기사 처리기사 정보
			for (Element element : topRankArticle) {
				Map<String, String> resultMap = new HashMap<String, String>();
				
				resultMap.put("link", element.select("a").attr("href"));
				resultMap.put("imageUrl", element.select(".mediatype img").attr("src").replaceAll("http://thumbnews.nateimg.co.kr/news90/", ""));
				resultMap.put("title", element.select(".tb strong").text());
				resultMap.put("contents", element.select(".tb").text());
				
				resultList.add(resultMap);
				resultMap = null;
			}
			
//			Iterator<Map<String, String>> iterator = resultList.iterator();
//			while (iterator.hasNext()) {
//				
//				iterator.next().put("cpNm", value);
//				
//			}
			
			for (Element element : topRankCpName) {
				
			}
			
			
			
			
					
			
//			resultList.add();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
}