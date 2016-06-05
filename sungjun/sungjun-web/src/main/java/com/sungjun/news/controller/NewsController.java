package com.sungjun.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NewsController {

	@RequestMapping(value="/news")
	public String findNewsMainPage (Model model) {
		
		// 선택 Sidebar 메뉴 셋팅
		Map<String, String> sidebarMenuData = new HashMap<String, String>();
		sidebarMenuData.put("news", "active");
		
		RestTemplate restTemplate = new RestTemplate();
//		Map<String, Object> dailyQTData = restTemplate.getForObject("http://localhost:8081/api/news/daily-qt", null, Map.class);
		
		List<Object> sisaRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sisa-rank", List.class);
		List<Object> sportsRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sports-rank", List.class);
		List<Object> entertainmentRankNewsList	= restTemplate.getForObject("http://localhost:8081/api/news/entertainment-rank", List.class);
		List<Object> naverRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/naver-realrank", List.class);
		List<Object> daumRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/daum-realrank", List.class);
		List<Object> financeUpperKospiList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kospi", List.class);
		List<Object> financeUpperKosdaqList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kosdaq", List.class);
		
		System.out.println(sisaRankNewsList);
		System.out.println(sportsRankNewsList);
		System.out.println(entertainmentRankNewsList);
		System.out.println(financeUpperKospiList);
		System.out.println(financeUpperKosdaqList);
		
		model.addAttribute("sisaRankNewsList", sisaRankNewsList);
		model.addAttribute("sportsRankNewsList", sportsRankNewsList);
		model.addAttribute("entertainmentRankNewsList", entertainmentRankNewsList);
		model.addAttribute("naverRealRankList", naverRealRankList);
		model.addAttribute("daumRealRankList", daumRealRankList);
		model.addAttribute("financeUpperKospiList", financeUpperKospiList);
		model.addAttribute("financeUpperKosdaqList", financeUpperKosdaqList);
		model.addAttribute("sidebarMenuData", sidebarMenuData);
		
		return "/news/news";
	}
}
