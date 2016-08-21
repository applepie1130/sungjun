package com.sungjun.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

	@RequestMapping(value="/template")
	public String findTemplate (Model model) {
		return "/template/template";
	}
}
