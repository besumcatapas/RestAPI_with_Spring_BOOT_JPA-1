package com.tapas.demo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(path = "/test0")
	public String testMethod0() {
		return "test web service 0";
	}
	
	@RequestMapping("/test1")
	@GetMapping
	public String testMethod1() {
		return "test web service 1";
	}
	
	@RequestMapping(value = "/test2" , method = RequestMethod.GET)
	public String testMethod2() {
		return "test webservice 2";
	}
	
	@RequestMapping(value="/test3/{s1}/{s2}", method = RequestMethod.GET)
	public String testMethod3(@PathVariable String s1, @PathVariable String s2) {
		return "test webservice 3, s1 = "+s1+" value of s2 ="+s2;
	}
	
	@RequestMapping( value = "test4" , method = RequestMethod.GET)
	public String testMethod4(@RequestParam(value="s3", required = true) String s3,@RequestParam(value="s4", required = false) String s4) {
		return "test webservice 4, s3 = "+s3+" value of s4 ="+s4;
	}
}
