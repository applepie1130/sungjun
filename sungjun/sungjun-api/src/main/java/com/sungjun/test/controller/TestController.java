package com.sungjun.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class TestController {
	
	@RequestMapping(
			value="/map",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
//	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> testController() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> resultList = new ArrayList<String>();
		resultList.add("하하하하하");
		resultList.add("호호호호호");
		
		resultMap.put("key", "value");
		resultMap.put("list", resultList);
		return resultMap;
	}

}
