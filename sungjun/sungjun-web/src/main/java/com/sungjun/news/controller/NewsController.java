package com.sungjun.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sungjun.news.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping("/news")
	public String findNewsMainPageNoParam(Model model) {
		return findNewsMainPage("all", model);
	}

	@RequestMapping("/news/{type}")
	public String findNewsMainPage (@PathVariable String type, Model model) {
		// 선택 Sidebar 메뉴 셋팅
		Map<String, String> sidebarMenuData = new HashMap<String, String>();
		sidebarMenuData.put("news", "active");
		
		String title = "종합";
		String color = "success";
		
		if ( "sisa".equals(type) ) {
			title = "시사";
			color = "danger";
			
		} else if ( "sports".equals(type) ) {
			title = "스포츠";
			color = "primary";
			
		} else if ( "entertainment".equals(type) ) {
			title = "연예";
			color = "warning";
			
		} else {
			title = "종합";
			color = "success";
		}
		
		List<Map<String, String>> rankNewsList = newsService.findNewsMainPage(type);
		
		model.addAttribute("rankNewsList", rankNewsList);
		model.addAttribute("sidebarMenuData", sidebarMenuData);
		model.addAttribute("title", title);
		model.addAttribute("color", color);
		
		return "/news/news";
	}
	
//	@RequestMapping(value="/news/sports")
//	public String findNewsSportsPage (Model model) {
//		
//		// 선택 Sidebar 메뉴 셋팅
//		Map<String, String> sidebarMenuData = new HashMap<String, String>();
//		sidebarMenuData.put("news", "active");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		List<Object> sisaRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sisa-rank", List.class);
//		List<Object> sportsRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sports-rank", List.class);
//		List<Object> entertainmentRankNewsList	= restTemplate.getForObject("http://localhost:8081/api/news/entertainment-rank", List.class);
//		List<Object> naverRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/naver-realrank", List.class);
//		List<Object> daumRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/daum-realrank", List.class);
//		List<Object> financeUpperKospiList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kospi", List.class);
//		List<Object> financeUpperKosdaqList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kosdaq", List.class);
//		
//		System.out.println(sisaRankNewsList);
//		System.out.println(sportsRankNewsList);
//		System.out.println(entertainmentRankNewsList);
//		System.out.println(financeUpperKospiList);
//		System.out.println(financeUpperKosdaqList);
//		
//		model.addAttribute("sisaRankNewsList", sisaRankNewsList);
//		model.addAttribute("sportsRankNewsList", sportsRankNewsList);
//		model.addAttribute("entertainmentRankNewsList", entertainmentRankNewsList);
//		model.addAttribute("naverRealRankList", naverRealRankList);
//		model.addAttribute("daumRealRankList", daumRealRankList);
//		model.addAttribute("financeUpperKospiList", financeUpperKospiList);
//		model.addAttribute("financeUpperKosdaqList", financeUpperKosdaqList);
//		model.addAttribute("sidebarMenuData", sidebarMenuData);
//		
//		return "/news/news";
//	}
//	
//	@RequestMapping(value="/news/entertainment")
//	public String findNewsEntertaimentPage (Model model) {
//		
//		// 선택 Sidebar 메뉴 셋팅
//		Map<String, String> sidebarMenuData = new HashMap<String, String>();
//		sidebarMenuData.put("news", "active");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		List<Object> sisaRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sisa-rank", List.class);
//		List<Object> sportsRankNewsList			= restTemplate.getForObject("http://localhost:8081/api/news/sports-rank", List.class);
//		List<Object> entertainmentRankNewsList	= restTemplate.getForObject("http://localhost:8081/api/news/entertainment-rank", List.class);
//		List<Object> naverRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/naver-realrank", List.class);
//		List<Object> daumRealRankList			= restTemplate.getForObject("http://localhost:8081/api/news/daum-realrank", List.class);
//		List<Object> financeUpperKospiList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kospi", List.class);
//		List<Object> financeUpperKosdaqList		= restTemplate.getForObject("http://localhost:8081/api/news/finance-upper-kosdaq", List.class);
//		
//		System.out.println(sisaRankNewsList);
//		System.out.println(sportsRankNewsList);
//		System.out.println(entertainmentRankNewsList);
//		System.out.println(financeUpperKospiList);
//		System.out.println(financeUpperKosdaqList);
//		
//		model.addAttribute("sisaRankNewsList", sisaRankNewsList);
//		model.addAttribute("sportsRankNewsList", sportsRankNewsList);
//		model.addAttribute("entertainmentRankNewsList", entertainmentRankNewsList);
//		model.addAttribute("naverRealRankList", naverRealRankList);
//		model.addAttribute("daumRealRankList", daumRealRankList);
//		model.addAttribute("financeUpperKospiList", financeUpperKospiList);
//		model.addAttribute("financeUpperKosdaqList", financeUpperKosdaqList);
//		model.addAttribute("sidebarMenuData", sidebarMenuData);
//		
//		return "/news/news";
//	}
}
