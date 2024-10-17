/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.dao.VehiculoDAO;
import vista.AdmiVista;

/**
 *
 * @author USUARIO
 */
public class RegistroVehiculoController {

    //Atributos
    VehiculoDAO vehiculoDAO;
    AdmiVista admi;

    //Constructor
    public RegistroVehiculoController(AdmiVista admi,VehiculoDAO vehiculoDAO) {
        this.admi = admi; 
        this.vehiculoDAO = vehiculoDAO;
        
    }

    //Metodos
    public boolean registrarVehiculo() {
        //obtenemos los datos del form Vehiculo=JtetxField
        String marca = admi.getTxtMarca().getText();
        String modelo = admi.getTxtModelo().getText();
        String anio = admi.getTxtAnio().getText();
        String placa = admi.getTxtPlaca().getText();

        //Validacione de campos de Formulario
        //Marca
        if (marca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Marca no puede estar vacío");
            return false;//Sale del metodo si hay un error
        }
        if (!marca.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Los caracteres !especiales! en Marca no son valido");
            return false;
        }
        //Modelo
        if (modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Modelo no puede estar vacio");
            return false;
        }

        if (!modelo.matches("^[a-zA-z0-9]+$")) //Anio
        {
            JOptionPane.showMessageDialog(null,"Los caracteres !especiales! en Marca no son valido");
            return false;
        }
        //Anio
        if(anio.isEmpty()){
            JOptionPane.showMessageDialog(null,"Anio no puede estar vacio");
            return false;
        }
        if(!anio.matches("^[0-9]+$")){
            JOptionPane.showMessageDialog(null,"Ingrese solo numeros");
            return false;
        }
        //Placa
        if(placa.isEmpty()){
            JOptionPane.showMessageDialog(null,"Placa no puede estar vacia");
            return false;
        }
        if(!placa.matches("^[A-Za-z0-9+_-]+ $")){
            return false;
        
        }
        
        return true;
        
    }

}
