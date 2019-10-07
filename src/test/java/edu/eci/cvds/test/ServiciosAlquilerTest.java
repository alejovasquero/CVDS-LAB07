package edu.eci.cvds.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;
import org.junit.After;
import org.junit.Assert;

@Transactional
public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Transactional
    @Before
    public void setUp() throws ExcepcionServiciosAlquiler {
        serviciosAlquiler.registrarCliente(new Cliente("el macho", 2020202, "22222", "cll 666","Elmacho@callme.com"));
        serviciosAlquiler.registrarCliente(new Cliente("Rapel con aida merlano", 401, "222dd22", "cll 6d66","Elmacho@callmde.com")); 
        
    }


   
    //public abstract int valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler;
    @Test
    public void hacerEstarPruebas(){
        assertTrue(false);
    }




    //public abstract Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler;
    @Test
    public void deberiaExistirCliente() {
        try {
            Cliente a = serviciosAlquiler.consultarCliente(2020202);
            assertEquals(a.getNombre(), "el macho");
            a= serviciosAlquiler.consultarCliente(401);
            assertEquals(a.getNombre(), "Rapel con aida merlano");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void deberiaNoExistirCliente(){
        try {
            
            Cliente a = serviciosAlquiler.consultarCliente(500);
            assertTrue(a==null);
            a= serviciosAlquiler.consultarCliente(666);
            assertTrue(a==null);
            
        } catch (Exception e) {
            
        }
    }

    //public abstract List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler;

    @Test
    public void deberiaNoEstarRegistrado(){
        try {
            serviciosAlquiler.consultarItemsCliente(500);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            serviciosAlquiler.consultarItemsCliente(666);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void deberiaNoTenerItems(){
        try {
            assertTrue(serviciosAlquiler.consultarItemsCliente(2020202).size()==0);
            assertTrue(serviciosAlquiler.consultarItemsCliente(401).size()==0);
        } catch (Exception e) {
            //TODO: handle exception
        }

    }

    @Test
    public void deberiaTenerAlMenosUnItem(){
        //PREGUNTAR COMO SE INSERTA DE POOB A BASES
        assertTrue(false);
    }
    //public abstract List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler;
    @Test
    public void deberiaHaberClientes(){
        try {
            assertTrue(serviciosAlquiler.consultarClientes().size()>0);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    
    @Test
    public void deberiaNoHaberClientes(){
        try {
            assertTrue(serviciosAlquiler.consultarClientes().size()-2==0);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }



    //public abstract Item consultarItem(int id) throws ExcepcionServiciosAlquiler;
    //public abstract List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler;
    //public abstract long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler;
    //public abstract TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler;
    //public abstract List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler;
    //public abstract void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler;
    //public abstract void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler;
    //public abstract long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler;
    //public abstract void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler;
    //public abstract void registrarItem(Item i) throws ExcepcionServiciosAlquiler;
    //public abstract void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler;


    @After
    public void cerrar(){
        //sqlSession.commit();
        //sqlSession.close();
    }

}