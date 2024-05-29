package com.tps.esb.camel.bean;

import org.apache.camel.component.cxf.jaxws.CxfEndpoint;

import com.tps.esb.service.web.sei.SimpleSoap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

@ApplicationScoped
public class TestSoapWebEndpoint {

	@Produces
	@ApplicationScoped
	@Named
	public CxfEndpoint requestEndpoint() {
		CxfEndpoint endpoint = new CxfEndpoint();
		endpoint.setAddress("TestSoap");
		endpoint.setServiceClass(SimpleSoap.class);
		return endpoint;
	}

}
