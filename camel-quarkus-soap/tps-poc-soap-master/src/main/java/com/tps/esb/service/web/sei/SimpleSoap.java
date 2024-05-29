package com.tps.esb.service.web.sei;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

@WebService(name = "UserContext")
@SOAPBinding(style = Style.DOCUMENT)
public interface SimpleSoap {

	@WebMethod(operationName = "login")
	@WebResult(name = "WSreturn")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
	public String login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) throws Exception;

	@WebMethod(operationName = "getUserInfo")
	@WebResult(name = "WSreturn")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
	public String getUserInfo(@WebParam(name = "user") User user) throws Exception;
	 
}