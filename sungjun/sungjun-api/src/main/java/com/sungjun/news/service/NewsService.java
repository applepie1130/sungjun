package com.sungjun.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sungjun.common.FileCommonUtils;

@Service
@Transactional
public class NewsService {

	@Autowired
	FileCommonUtils fileCommonUtils;
	
	public Map<String, Object> getDailyQTData(Map<String, Object> paramMap) {
		
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONMap(filePath);
	}
	
	public List<Object> getSisaRankingNewsList(Map<String, Object> paramMap) {
		
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getSportsRankingNewsList(Map<String, Object> paramMap) {
		
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getEntertainmentRankingNewsList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getRealRankWithNaverList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getRealRankWithDaumList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	
	public List<Object> getKOSPIUpperList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getKOSDAQUpperList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
	
	public List<Object> getFinanceTrendRankList(Map<String, Object> paramMap) {
		String filePath = String.valueOf(paramMap.get("filePath"));
		
		return fileCommonUtils.readFileFromJSONList(filePath);
	}
}
