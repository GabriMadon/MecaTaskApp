/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author juand
 */
public class ConexionDB {

    private static Connection connection;

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws IOException, SQLException {
        
        if (connection == null || connection.isClosed()) {
            try {
                InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("modelo/dao/db_config.properties");

                // Cargar el archivo de configuración
                if (input == null) {
                    throw new IOException("Lo siento, no se pudo encontrar db_config.properties");

                }
                Properties props = new Properties();
                // Cargar propiedades
                props.load(input);

                // Obtener las propiedades
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                // Establecer conexión
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión exitosa a la DB gestion_tareas");

            } catch (SQLException e) {
                System.out.println("Error al conectarse a la DB gestion_tareas: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
         

    public static void main(String[] args) {
        try {
            // Abrir la conexión
            Connection connection = ConexionDB.getConnection();

            // Realizar operaciones con la base de datos si es necesario
            System.out.println("Realizando operaciones con la base de datos...");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Asegurarse de cerrar la conexión después de las operaciones
            ConexionDB.closeConnection();
            System.out.println("Fin de la ejecución de main()");
        }
    }

}
