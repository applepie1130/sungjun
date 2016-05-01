package com.sungjun.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sungjun.news.service.NewsService;

@RestController
@RequestMapping("/api/news/")
public class NewsController {
	
	@Autowired(required=false)
	NewsService newsService;
	
	@RequestMapping(
			value="/daily-qt",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Map<String, Object> getDailyQTData() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("filePath", "/tank0/batch/DailyQTMap.json");
		
		return newsService.getDailyQTData(paramMap);
	}
	
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
	
}