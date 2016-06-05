package com.sungjun.devtools.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevToolsController {

	@RequestMapping(value="/codegen")
	public String findCodegenPage (Model model) {
		
		// 선택 Sidebar 메뉴 셋팅
		Map<String, String> sidebarMenuData = new HashMap<String, String>();
		sidebarMenuData.put("devtools", "active");
		sidebarMenuData.put("codegen", "active");
		
		model.addAttribute("sidebarMenuData", sidebarMenuData);
		
		return "/devtools/codegen";
	}
}
