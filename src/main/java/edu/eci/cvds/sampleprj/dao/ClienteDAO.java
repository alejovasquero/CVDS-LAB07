package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.List;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

public interface ClienteDAO{
	
	public void save(Cliente it) throws PersistenceException;

	public Cliente load(long id) throws PersistenceException;
	
	public List<Cliente> consultarClientes() throws PersistenceException;
	
	public List<ItemRentado> loadItems(long idcliente) throws PersistenceException;

	public void vetarCliente(long docu, boolean estado) throws PersistenceException;
}