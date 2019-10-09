package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.sampleprj.dao.*;

import edu.eci.cvds.samples.entities.*;

import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private ClienteDAO clienteDAO;
    @Inject
    private ItemRentadoDAO itemRentadoDAO;
    @Inject
    private ItemDAO itemDAO;
    @Inject
    private TipoItemDAO tipoItemDAO;

    @Override
    public int valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.valormultaretraso(itemId);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item " + itemId, ex);
        }
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.load(docu);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el cliente " + docu, ex);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        List<ItemRentado> ans = null;
        try {
            if(consultarCliente(idcliente)==null){
                throw new ExcepcionServiciosAlquiler("El cliente no está registrado: "+ idcliente);
            }
            ans = clienteDAO.loadItems(idcliente);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el cliente " + idcliente, ex);
        }
        return ans;
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.consultarClientes();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes", ex);
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        Item ans=null;
        try {
            ans=itemDAO.load(id);
            if(ans==null){
                throw new ExcepcionServiciosAlquiler("El item no existe: " + id);
            }
            } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item " + id, ex);
        }
        return ans;
    }

    @Override
    public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.consultarItemsDisponibles();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar los items disponibles", ex);
        }
    }

    // falta
    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            System.out.println(iditem);
            ItemRentado a=itemRentadoDAO.load(iditem);
            System.out.println(iditem);
            if(a==null || itemRentadoDAO.load(iditem)==null){
                throw new ExcepcionServiciosAlquiler("No hay información de el item rentado: "+ iditem);
            }
            LocalDate fechaMinimaEntrega=a.getFechafinrenta().toLocalDate();
            LocalDate fechaEntrega=fechaDevolucion.toLocalDate();
            long diasRetraso = ChronoUnit.DAYS.between(fechaMinimaEntrega, fechaEntrega);            
            return diasRetraso;
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item rentado: "+ iditem, e);
        }
        
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el tipo de item " + id, ex);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.consultarTiposItem();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar los tipos de item", ex);
        }
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias)
            throws ExcepcionServiciosAlquiler {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, numdias);
            itemRentadoDAO.save(docu,item.getId(), date, new java.sql.Date(calendar.getTime().getTime()));
        } catch (Exception ex) {
            throw new ExcepcionServiciosAlquiler(
                    "Error al registrar el alquiler del producto " + item.toString() + " por el cliente " + docu, ex);
        }
    }

    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        try {
            clienteDAO.save(c);
            for(ItemRentado a: c.getRentados()){
                itemDAO.save(a.getItem());
            }
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar el cliente " + c.toString(), ex);
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        long ans=0;
        try {
            if(itemDAO.load(iditem)==null){
                throw new ExcepcionServiciosAlquiler("El item no está registrado: " + iditem);
            }
            ans = itemDAO.consultarCostoAlquiler(iditem, numdias);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item " + iditem, ex);
        }
        return ans;
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        try {
            itemDAO.actualizarTarifaItem(id, tarifa);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al actualizar la tarifa del item " + id, ex);
        }
    }

    @Transactional
    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        try {
            if(tipoItemDAO.load(i.getTipo().getID())==null){
                tipoItemDAO.save(i.getTipo());
            }
            itemDAO.save(i);
            
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar el item " + i.toString(), ex);
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        try {
            clienteDAO.vetarCliente(docu, estado);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar el vetar el cliente " + docu, ex);
            
        }
       
   }

    @Override
    public void registrarTipoItem(TipoItem a) {
        try {
            tipoItemDAO.save(a);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Override
    public List<ItemRentado> consultarItemsRentadosSinDevolver(long documento) throws ExcepcionServiciosAlquiler {
        try {
            if(clienteDAO.load(documento)==null){throw new ExcepcionServiciosAlquiler("No existe el cliente: " + documento);}
            return itemRentadoDAO.consultarItemsSinDevolver(documento);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar items de: " + documento, e);
        }

    }
}