/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gabrimadon.mecatask;

import com.mysql.cj.xdevapi.SchemaImpl;
import controlador.LoginController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.dao.ConexionDB;
import modelo.dao.UsuarioDAO;
import vista.LoginVista;

/**
 *
 * @author juand
 */
public class MecaTask {

    public static void main(String[] args) {

        try {
            // Obtener la conexión a la base de datos
            Connection connection = ConexionDB.getConnection();

            // Crear el DAO y la vista
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            LoginVista loginVista = new LoginVista(usuarioDAO);

            // Crear el controlador y pasar el DAO y la vista
            LoginController loginController = new LoginController(loginVista, usuarioDAO);


            // Mostrar la vista Formulario de inicio de Sesion

            // Mostrar la vista

            loginVista.setVisible(true);
            loginVista.setLocationRelativeTo(null);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la aplicación: " + e.getMessage());
        }
        
        

    }

}
