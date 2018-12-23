package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import com.example.demo.delegate.soap.CalculatorDelegate;

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
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("org.tempuri");
		return marshaller;
	}

	@Bean             
	public CalculatorDelegate calculatorDelegate(final Jaxb2Marshaller marshaller) {
		CalculatorDelegate delegate = new CalculatorDelegate();
		delegate.setDefaultUri(calculatorEndpoint);
		delegate.setMarshaller(marshaller);
		delegate.setUnmarshaller(marshaller);
		log.info(String.format("adding results using soap webservice result[%d]", delegate.add(1, 2)));
		return delegate;
	}
	
  
}
