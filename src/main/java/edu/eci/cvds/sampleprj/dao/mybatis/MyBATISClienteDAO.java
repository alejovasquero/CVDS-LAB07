package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import com.google.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

public class MyBATISClienteDAO implements ClienteDAO{

	@Inject
	private ClienteMapper clienteMapper;
	
	
	@Transactional
	@Override
	public void save(Cliente cli) throws PersistenceException{
		try{
			clienteMapper.insertarCliente(cli);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el cliente "+cli.toString(),e);
		}        
	}
	
	
	@Override
	public Cliente load(long id) throws PersistenceException {
		try{
			return clienteMapper.consultarCliente(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el cliente "+id,e);
		}
	}
	

	@Override
	public List<Cliente> consultarClientes() throws PersistenceException{
		try{
			return clienteMapper.consultarClientes();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar los clientes",e);
		}
	}
	
	
	@Override
	public List<ItemRentado> loadItems(long idcliente) throws PersistenceException{
		try{
			return clienteMapper.consultarItems(idcliente);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el cliente "+idcliente,e);
		}
	}

	@Transactional
	@Override
	public void vetarCliente(long docu, boolean estado) throws PersistenceException {
		try{
			clienteMapper.vetarCliente(docu, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al vetar Cliente "+docu,e);
		}
		

	}
}