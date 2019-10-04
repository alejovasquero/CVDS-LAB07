package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import java.sql.SQLException;
import java.util.List;

public class MyBATISItemDAO implements ItemDAO{

  @Inject
  private ItemMapper itemMapper;    

  @Override
  public void save(Item it) throws PersistenceException{
	try{
		itemMapper.insertarItem(it);
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al registrar el item "+it.toString(),e);
	}        
  }

  @Override
  public Item load(int id) throws PersistenceException {
	try{
		return itemMapper.consultarItem(id);
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al consultar el item "+id,e);
	}
  }
  
  //falta calcular el valor de la multa con lo que da el mapper
  @Override
  public int valormultaretraso(int itemId) throws PersistenceException{
	try{
		itemMapper.valorMultaRetrasoxDia(itemId);
		return 0;
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al consultar el item "+itemId,e);
	}
  }
  
  @Override
  public List<Item> consultarItemsDisponibles() throws PersistenceException{
	try{
		return itemMapper.consultarItemsDisponibles();
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al consultar los items disponibles",e);
	}
  }
  
  @Override
  public long consultarCostoAlquiler(int iditem, int numdias) throws PersistenceException{
	try{
		return itemMapper.consultarCostoAlquiler(iditem)*numdias;
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al consultar el costo del alquiler",e);
	}
  }
  
  @Override
  public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException{
	try{
		itemMapper.actualizarTarifaItem(id,tarifa);
	}catch(org.apache.ibatis.exceptions.PersistenceException e){
		throw new PersistenceException("Error al actualizar la tarifa del item "+id,e);
	}
  }
}