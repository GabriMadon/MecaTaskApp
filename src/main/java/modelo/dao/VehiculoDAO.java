/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.dao.entidades.Usuario;
import modelo.dao.entidades.Vehiculo;

/**
 *
 * @author USUARIO
 */
public class VehiculoDAO {
        //Atributos
    private Connection connection;

    //Constructor
    public VehiculoDAO(Connection connection) {
        this.connection = connection;
    }
    
        //Metodos para operaciones SQL
    //INSERT
    public void registrarVehiculo(Vehiculo vehiculo) throws SQLException {

        if(vehiculo == null){
            throw new IllegalArgumentException("El usuario no puede ser nuelo");
            
        }
        System.out.println("NombreDAO " + vehiculo.getMarca());
        System.out.println("ApellidoDAO " + vehiculo.getModelo());
        System.out.println("ApellidoDAO " + vehiculo.getAnio());
        System.out.println("ApellidoDAO " + vehiculo.getPlaca());
        //String sql = "INSERT INTO usuarios (marca, modelo ,anio,placa) "

        String sql = "INSERT INTO usuarios (marca, modelo ,anio, placa) "

                + "VALUE(?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setInt(3,vehiculo.getAnio());
            statement.setString(4, vehiculo.getPlaca());
          
            statement.executeUpdate();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
