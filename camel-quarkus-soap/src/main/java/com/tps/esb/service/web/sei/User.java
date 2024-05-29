package com.tps.esb.service.web.sei;
  
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped; 

@ApplicationScoped
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private String correo;

	public User() {
	}

	public User(String correo) {
		this.correo = correo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getInfo(String format) { 
		try {
			String nombre = correo.split("@")[0]; 
			String empresa = correo.split("@")[1]; 
			return format.replace("@NOMBRE", nombre ).replace("@DOMINIO", empresa ); 
		}catch (Exception e) {
			return "Format Error";
		}
	}

	@Override
	public String toString() {
		return "User [correo=" + correo + "]";
	}

}
