package com.tps.esb.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import com.tps.esb.camel.processor.Save;
import com.tps.esb.model.Response;
import jakarta.enterprise.context.ApplicationScoped;
 
@ApplicationScoped
public class WebRouteRest extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		//metodos
		from("direct:getToken")
			.id("getToken")
			.tracing()
			.to("direct:getTokenFromContext") // Reemplaza al direct-vm -> invocamos ruta al AMQ - JMS
			.process(x -> { 
					Response response = new Response();
					response.ready(x.getProperty("token", String.class)); 
					x.getMessage().setBody(response); 
			})
			.marshal()
			.json()
		.end();
		
		from("direct:save")
			.id("save")
			.tracing()
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))
			.setHeader(Exchange.CONTENT_TYPE, constant("application/x-www-form-urlencoded"))
			.log("testData=${body}")
			.to("direct:validTokenUserContext") // Reemplaza al direct-vm -> invocamos ruta al AMQ - JMS
			.bean(Save.class, "process")
			.marshal()
			.json()
		.end();
		
	}

}
