package com.tps.esb.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.microprofile.config.ConfigProvider;

import com.tps.esb.service.web.sei.User;

public class GetUserInfo implements Processor {

	private String info = ConfigProvider.getConfig().getValue("user.get.info", String.class);
	
	@Override
	public void process(Exchange exchange) throws Exception { 
		User user = exchange.getProperty("user", User.class);
		exchange.getMessage().setHeader("response", user.getInfo(info));  
	}

}
