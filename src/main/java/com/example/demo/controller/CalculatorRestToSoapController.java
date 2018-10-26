package com.example.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.CalculatorSoap;

@RestController
public class CalculatorRestToSoapController {
	
	@Resource(name="calculator")
	private CalculatorSoap calculator;
	
	private static final Logger log = LoggerFactory.getLogger(CalculatorRestToSoapController.class);
	
	@GetMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public int add(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		log.info(String.format("adding %d and %d before calling SOAP service", num1, num2));
		int result = calculator.add(num1,num2);
		log.info(String.format("adding %d and %d resulted in %d", num1, num2, result));
		return result;
	}

}
