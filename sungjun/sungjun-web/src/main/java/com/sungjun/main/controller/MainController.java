package com.sungjun.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

	@RequestMapping(value="/main_org")
	public String findBlogMainOrgPage (Model model) {
		
		return "/main/main_org";
	}
	
	
	@RequestMapping(value="/")
	public String findMainHomePage (Model model) {
		
		// 선택 Sidebar 메뉴 셋팅
		Map<String, String> sidebarMenuData = new HashMap<String, String>();
		sidebarMenuData.put("home", "active");
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> dailyQTData		= restTemplate.getForObject("http://localhost:8081/api/news/daily-qt", Map.class);
		List<Object> naverRealRankList		= restTemplate.getForObject("http://localhost:8081/api/news/naver-realrank", List.class);
		List<Object> daumRealRankList		= restTemplate.getForObject("http://localhost:8081/api/news/daum-realrank", List.class);
		
		model.addAttribute("sidebarMenuData", sidebarMenuData);
		model.addAttribute("dailyQTData", dailyQTData);
		model.addAttribute("naverRealRankList", naverRealRankList);
		model.addAttribute("daumRealRankList", daumRealRankList);
		
		return "/main/main";
	}
}
