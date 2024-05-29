package com.tps.esb.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JMSRoute extends RouteBuilder {

	@ConfigProperty(name = "user.token")
	String configToken;
	
	@Override
	public void configure() throws Exception {
		from("jms:queue:getTokenFromContext")
			.setBody(simple(configToken));
		
		from("jms:queue:validTokenUserContext")
			.to("direct:validTokenUserContext");
	}

}
