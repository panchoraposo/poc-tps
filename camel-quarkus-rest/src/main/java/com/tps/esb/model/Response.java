package com.tps.esb.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Response {

	private String status;
	private String mensaje;
	private String fechaSolicitud;
	private Object body;
	
	public Response() {
		this.fechaSolicitud = fechaActual();
		this.status = "1";
		this.mensaje = "Error al procesar la solicitud";
	}
	public Response(String status, String mensaje) {
		this.status = status;
		this.mensaje = mensaje;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
	public Object getBody() {
		return body;
	}
	
	public void setBody(Object body) {
		this.body = body;
	}
	
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	private String fechaActual() {
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:MM"); 
		return formatoFecha.format(new Date()).toString();
	}
	
	public void ready(Object object) {
		this.body = object;
		this.status = "1";
		this.mensaje = "Datos recuperados/capturados";
	}
	
	public void error(String mensaje, Exception e) {
		this.body = e.getMessage() + " CAUSA: " + e.getCause();
		this.status = "0";
		this.mensaje = mensaje;
	}
	
	public void error(String mensaje) {
		this.body = "Error Generico";
		this.status = "0";
		this.mensaje = mensaje;
	}
	
	
	@Override
	public String toString() {
		return "Response [status=" + status + ", mensaje=" + mensaje + "]";
	}
	
}
