package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "alquilerBean")
@SessionScoped
public class AlquilerItemsBean extends BasePageBean{

    private static final long serialVersionUID = 7492816763998634328L;
    private Cliente selectedCliente;
    @Inject
    private ServiciosAlquiler serviciosAlquiler;

    public List<Cliente> consultarClientes(){
        List<Cliente> clientes = null;
        try {
            clientes = serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
        }
        return clientes;
    }

    public void agregarCliente(String nombre, long documento, String telefono, String direccion, String email){
        try {
            serviciosAlquiler.registrarCliente(new Cliente(nombre,documento,telefono,direccion,email));
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {

        }
    }

    public Cliente getselectedCliente(){

        return selectedCliente;
    }

    public void setselectedCliente(Cliente selectedCliente){
        System.out.println(selectedCliente);
        this.selectedCliente = selectedCliente;
    }


    public List<ItemRentado> consultarItemsRentadosSinDevolver(){
        List<ItemRentado> ans = null;
        
        if(selectedCliente!=null){
            System.out.println(selectedCliente.getNombre());
            try {
                ans = serviciosAlquiler.consultarItemsRentadosSinDevolver(selectedCliente.getDocumento());
            } catch (ExcepcionServiciosAlquiler e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ans;
        

    }

    public long consultarMulta(int item) throws Exception {
        long a=0;
        try {
            a=serviciosAlquiler.consultarMultaAlquiler(item, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        } catch (Exception e) {
            
        }
        return a;
    }
}