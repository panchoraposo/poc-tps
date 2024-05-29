package com.tps.esb.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.microprofile.config.ConfigProvider;

public class Login implements Processor {
	
	String user = ConfigProvider.getConfig().getValue("login.get", String.class);
	String password = ConfigProvider.getConfig().getValue("password.get", String.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		String inUser = exchange.getProperty("user", String.class);
		String inPassword = exchange.getProperty("password", String.class);
		
		if (inPassword.equals(password.trim()) && inUser.equals(user.trim())) {
			exchange.getMessage().setHeader("response", "Identificado");
		} else {
			exchange.getMessage().setHeader("response", "Error User/Password");
		}
	}
	

}
