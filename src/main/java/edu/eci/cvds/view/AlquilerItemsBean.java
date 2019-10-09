package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "alquilerBean")
public class AlquilerItemsBean extends BasePageBean{

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

    public Cliente getSelectedCliente(){
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente){
        this.selectedCliente = selectedCliente;
    }


    public List<ItemRentado> consultarItemsRentadosSinDevolver(){
        List<ItemRentado> ans = null;
        if(selectedCliente!=null){
            ans = serviciosAlquiler.consultarItemsRentadosSinDevolver();
        }
        return ans;
        

    }
}