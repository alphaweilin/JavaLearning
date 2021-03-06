package com.example.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
	
	@RequestMapping(value= {"/","hi"})
	String home(){
		return "hello world!";
	}
	
	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName){
		return "Hello:" + myName + "!";
	}
}
