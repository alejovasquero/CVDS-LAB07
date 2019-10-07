package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
	private static final long serialVersionUID = 1L;

	public ExcepcionServiciosAlquiler(String message, Exception e) {
		super(message,e);
	}
	
	public ExcepcionServiciosAlquiler(String message){
		super(message);
	}
}