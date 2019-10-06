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

    @Before
    public void setUp() throws ExcepcionServiciosAlquiler {
        serviciosAlquiler.registrarCliente(new Cliente("el macho", 2020202, "22222", "cll 666","Elmacho@callme.com"));
    }

    @Test
    public void deberiaExistirCliente() {
        try {
            Cliente a = serviciosAlquiler.consultarCliente(2020202);
            assertEquals(a.getNombre(), "el macho");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void deberiaNoExistirCliente(){
        try {
            
            Cliente a = serviciosAlquiler.consultarCliente(111);
            assertTrue(a==null);
            
        } catch (Exception e) {
            
        }
    }

    @After
    public void cerrar(){
        //sqlSession.commit();
        //sqlSession.close();
    }

}