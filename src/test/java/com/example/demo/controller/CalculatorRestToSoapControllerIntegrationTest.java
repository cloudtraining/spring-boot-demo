package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.SpringBootDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorRestToSoapControllerIntegrationTest {
	
	@Autowired
	private CalculatorRestToSoapController calc;
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void callcontroller_add() {
		int actual = calc.add(2, 3);
		assertEquals(5, actual);
	}
	@Test
	public void restcall_add() {
		Integer actual = testRestTemplate.getForObject("/add?num1=1&num2=3", Integer.class);
		
		assertNotNull(actual);
		assertEquals(4, actual.intValue());
	}
}
