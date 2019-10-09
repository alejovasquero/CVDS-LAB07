package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

public class Main {

    public static void main(String[] args) throws ExcepcionServiciosAlquiler {
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(123456));
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarClientes());
        System.exit(0);
    }
}
