package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
	public ExcepcionServiciosAlquiler(String message,Exception e){
		super(message,e);
	}
	
	public ExcepcionServiciosAlquiler(String message){
		super(message);
	}
}