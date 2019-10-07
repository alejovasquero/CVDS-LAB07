package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.ItemRentado;

import java.sql.Date;

public interface ItemRentadoDAO{
	
	public ItemRentado load(int id) throws PersistenceException;
	
	public void save(long docu,int itemId,Date fechaIni,Date fechaFin) throws PersistenceException;
	
}