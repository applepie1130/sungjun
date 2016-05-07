package com.sungjun.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {

	@RequestMapping(value="/news")
	public String findNewsMainPage (Model model) {
		return "/news/news";
	}
}
