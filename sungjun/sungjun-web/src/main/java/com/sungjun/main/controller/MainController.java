package com.sungjun.main.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String findBlogMainPage (Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> resultData = restTemplate.postForObject("http://localhost:8081/api/news/daily-qt", null, Map.class);
		
		System.out.println(resultData);
		
		return "/main/main";
	}
}
