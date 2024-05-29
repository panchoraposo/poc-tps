package com.tps.esb.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.tps.esb.model.Response;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Save implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Response response = new Response();
		 
		boolean isValid = exchange.getMessage().getHeader("tokenValid", boolean.class);
		if (isValid) {  
			response.ready("Save: " + exchange.getIn().getHeader("nombre", String.class));  
		} else {
			response.error("Token not valid");
		}
		exchange.getMessage().setBody(response);
 	}

}
