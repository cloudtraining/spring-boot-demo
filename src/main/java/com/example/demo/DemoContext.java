package com.example.demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.tempuri.CalculatorSoap;

@Configuration
public class DemoContext {
	private static final Logger log = LoggerFactory.getLogger(DemoContext.class);

	@Value("${calculator.endpoint}")
	private String calculatorEndpoint;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CalculatorSoap calculator() {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(CalculatorSoap.class);
		factoryBean.setAddress(calculatorEndpoint);
		log.info("creating CalculatorSoap");
		CalculatorSoap calc = (CalculatorSoap) factoryBean.create();
		log.info(String.format("adding results using soap webservice result[%d]", calc.add(1, 2)));
		return calc;

	}
  
}
