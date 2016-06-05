package com.sungjun.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		model.addAttribute("sidebarMenuData", sidebarMenuData);
		
		return "/main/main";
	}
}
