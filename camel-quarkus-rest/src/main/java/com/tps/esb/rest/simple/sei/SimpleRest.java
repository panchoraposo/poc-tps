package com.tps.esb.rest.simple.sei;

import com.tps.esb.camel.MainRouteBuilder;

public class SimpleRest extends MainRouteBuilder {

	@Override
	protected void addRoutes() throws Exception {

		rest("/simpleRest")
			.description("Simple Rest")
			.get("/getToken")
				.description("GET Token")
				.produces("application/json")
				.to("direct:getToken")
		
			.post("/save")
				.description("POST Save")
				.produces("application/json")
				.consumes("application/x-www-form-urlencoded")
				.to("direct:save");
				
	}
	
	
}

 
