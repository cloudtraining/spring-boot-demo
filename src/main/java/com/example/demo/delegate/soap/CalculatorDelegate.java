package com.example.demo.delegate.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.tempuri.Add;
import org.tempuri.AddResponse;
public class CalculatorDelegate extends WebServiceGatewaySupport {

	public int add(int num1, int num2) {
		Add addInput = new Add();
		addInput.setIntA(num1);
		addInput.setIntB(num2);
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(addInput, 
				new SoapActionCallback("http://tempuri.org/Add"));
		return response.getAddResult();
	}
}
