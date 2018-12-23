package com.example.demo.delegate.soap;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoContext;
@RunWith(SpringRunner.class)
@TestPropertySource(locations= {"classpath:application.properties"})
@ContextConfiguration(classes= {DemoContext.class})
public class CalculatorDelegateIntegrationTest {
	
	@Resource(name="calculatorDelegate")
	private CalculatorDelegate calculator;

	@Test
	public void callcontroller_add() {
		int actual = calculator.add(2, 3);
		assertEquals(5, actual);
	}
}
