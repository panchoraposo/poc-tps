package com.tps.esb.camel.route;
 
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import com.tps.esb.camel.processor.GetUserInfo;
import com.tps.esb.camel.processor.Login;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WebRouteLogin extends RouteBuilder {
	
	@ConfigProperty(name = "user.token") 
	String configToken;

	@Override
	public void configure() throws Exception {
		
		//operaciones - switch 
		from("cxf:bean:requestEndpoint")
			.tracing()
			.setProperty("dynRouteByOperation", simple("direct:${header.operationName}Internal"))  
			.routingSlip(exchangeProperty("dynRouteByOperation")) 
		.end();
		
		//metodos
		from("direct:loginInternal")
			.id("login")
			.log("====== LOGIN ======")
			.tracing()
			.setProperty("user", simple("${body[0]}"))
			.setProperty("password", simple("${body[1]}"))
			.bean(Login.class, "process")
			.to("velocity:/META-INF/vm/template.vm")    
		.end();

		from("direct:getUserInfoInternal")
			.id("getUserInfo")
			.log("====== GET_USER_INFO ======")
			.tracing()  
			.setProperty("user", simple("${body[0]}")) 
			.bean(GetUserInfo.class, "process")
			.to("velocity:/META-INF/vm/template.vm")    
		.end();

		//DIRECT 
		//generar token
		from("direct:getTokenUserContext")
			.id("getTokenUserContext") 
			.setProperty("token", simple(configToken)) // Reemplaza al .to("getTokenUserContextBean")
		.end();
		
		//validar token 
		from("direct:validTokenUserContext")
			.id("validTokenUserContext") 
			.setProperty("token", simple(configToken)) // Reemplaza al .to("getTokenUserContextBean") 
			.process(x -> {
				if(x.getProperty("token").equals(x.getIn().getHeader("token"))) {
					x.getMessage().setHeader("tokenValid", true); // x.setProperty("tokenValid", true); Las properties son principalmente propiedades del Exchange y no del mensaje
				} else {
					x.getMessage().setHeader("tokenValid", false); // x.setProperty("tokenValid", false); Por lo cual si queremos enviarle por JMS a la otra App a traves de un mensaje no es posible con la propertie
				} 
			})    
	    .end();
		
	}
	
	
}