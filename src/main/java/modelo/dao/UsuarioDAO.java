/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import modelo.dao.entidades.Usuario;
import modelo.dao.entidades.Usuario.Rol;

/**
 *
 * @author juand
 */
public class UsuarioDAO {

    //Atributos
    private Connection connection;

    //Constructor
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    //Metodos para operaciones SQL
    //INSERT
    public void registrarUsuario(Usuario usuario) throws SQLException {

        if(usuario == null){
            throw new IllegalArgumentException("El usuario no puede ser nuelo");
            
        }
        System.out.println("NombreDAO " + usuario.getNombre());
        System.out.println("ApellidoDAO " + usuario.getApellido());
        System.out.println("EmailDao " + usuario.getEmail());
        System.out.println("ContraseniaDAO " + usuario.getContrasenia());
        System.out.println("Rol Dao " + usuario.getRol());
        //String sql = "INSERT INTO usuarios (nombre, apellido ,email, contrasenia, rol) "

        String sql = "INSERT INTO usuarios (nombre, apellido ,email, contrasenia, rol) "

                + "VALUE(?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, String.valueOf(usuario.getContrasenia()));
            statement.setString(5, usuario.getRol().name());
            statement.executeUpdate();
        }
    }

    //SELECT * FROM WHERE  -> buscar para crear cuenta
    public Usuario buscarUsuarioEmail(String email) throws SQLException {

        String sql = "SELECT * FROM usuarios WHERE email =? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

        //String sql = "SELECT * FROM usuarios WHERE email =? AND contrasenia =?";
 


            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setContrasenia(resultSet.getString("contrasenia").toCharArray());
                usuario.setRol(Rol.valueOf(resultSet.getString("rol")));

                return usuario;
            }
        }

        return null;//Retorna null si no se enceuntra el emali usuario
    }

    //SELECT * FROM WHERE  -> buscar email y contraseña si existen en la DB LOGIN
    public Usuario loginUsuario(String email, String contrasenia) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE email =? AND contrasenia =?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, contrasenia);
            
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    usuario= new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setApellido(resultSet.getString("apellido"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setContrasenia(resultSet.getString("contrasenia").toCharArray());
                    usuario.setRol(Rol.valueOf(resultSet.getString("rol")));
                    return usuario;
                }
            }catch(SQLException e){
                
            }
        }

        return null;//Retorna null si no se enceuntra el emali usuario
    }

    //Getters and Setters
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
