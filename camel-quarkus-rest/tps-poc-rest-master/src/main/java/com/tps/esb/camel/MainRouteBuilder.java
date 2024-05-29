package com.tps.esb.camel;

import org.apache.camel.builder.RouteBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public abstract class MainRouteBuilder extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		restConfiguration()
			.component("servlet")
			.enableCORS(true);
		addRoutes();
	}
	protected abstract void addRoutes() throws Exception;
}
