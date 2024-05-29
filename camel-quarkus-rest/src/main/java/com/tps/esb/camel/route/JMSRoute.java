package com.tps.esb.camel.route;

import org.apache.camel.builder.RouteBuilder;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JMSRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:getTokenFromContext")
			.to("jms:queue:getTokenFromContext?exchangePattern=InOut")
			.setProperty("token", body());
		
		from("direct:validTokenUserContext")
			.to("jms:queue:validTokenUserContext?exchangePattern=InOut");
	}

}
