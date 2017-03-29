package edu.tum.uc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.tum.cal.mul.MulNumbersRequest;
import edu.tum.cal.mul.MulNumbersResponse;

@Endpoint
public class MulEndpoint {
	private static final String NAMESPACE_URI = "http://mul.cal.tum.edu";
	
	private MulServiceImpl mulService = null;
	
	@Autowired
	public MulEndpoint(MulServiceImpl mulService){
		this.mulService = mulService;
	}
	
	@PayloadRoot(localPart = "MulNumbersRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public MulNumbersResponse add(@RequestPayload MulNumbersRequest numbers){
		MulNumbersResponse _return = new MulNumbersResponse();
		double r = this.mulService.mul(Double.parseDouble(numbers.getN1()), Double.parseDouble(numbers.getN2()));
		_return.setN1(String.valueOf(r));
		return _return;
	}
}
