/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.dao.UsuarioDAO;
import modelo.dao.entidades.Usuario;
import modelo.dao.entidades.Usuario.Rol;
import vista.RegistroVista;

/**
 *
 * @author USUARIO
 */
public class RegistroController {
    //Atributos

    private UsuarioDAO usuarioDAO;
    private RegistroVista vista;
    

    //Constructor
    public RegistroController(RegistroVista vista, UsuarioDAO usuarioDAO) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;
        
    }

    //Metodos
    public boolean registrarUsuario() {

        String nombre = vista.getTxtNombre().getText();
        String apellido = vista.getTxtApellido().getText();
        String email = vista.getTxtEmail().getText();
        String contrasenia = new String(vista.getjPassword().getPassword());
        //String rol = (String) vista.getCmbRol().getSelectedItem();

        //Validacion por nombre
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío");
            return false;//Sale del metodo si hay un error
        }

        if (!nombre.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null, "Los caracteres !num o especiales! en Nombre no son valido");
            return false;
        }
        //Validacion para Apellido
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Apellido no puede estar vacío");
            return false;//Sale del metodo si hay un error
        }

        if (!apellido.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null, "Los caractrese !num o especiales! en Apellido no son valido");
            return false;
        }

        //Validacion para email
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email no puede estar vacío");
            return false;//Sale del metodo si hay un error
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "El email ingresado no es valido");
            return false;
        }

        //Validacion para contraseña
        if (contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no puede estra vacio");
            return false;
        }

        if (contrasenia.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres");
            return false;
        }

        try {
            //loginUsuario verifica si el usuario existe en la DB - parametros del formulario LoginVista
            Usuario usuario = usuarioDAO.buscarUsuarioEmail(email);
            // si se encuentra usuario  devuelve un objeto usuario
            if (usuario != null) {

                JOptionPane.showMessageDialog(null, "Email usuario ya esta registrado");
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "LOGIN Error al acceder a la DB : " + ex.getMessage());
            return false;
        }

        return true;

    }

    public void registrar() {

        String nombre = vista.getTxtNombre().getText();
        String apellido = vista.getTxtApellido().getText();
        String email = vista.getTxtEmail().getText();
        //String contraseniaString = vista.getjPassword();
        char[] contrasenia = vista.getjPassword().getPassword();

        String rolSeleccionado = (String) vista.getCmbRol().getSelectedItem();

        System.out.println("Soy nombre : " + nombre);
        System.out.println("Soy apellido: " + apellido);
        System.out.println("Soy email : " + email);
        System.out.println("Contraseña: " + (contrasenia.length > 0 ? new String(contrasenia) : "No proporcionada"));
        System.out.println("Soy rol : " + rolSeleccionado);

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasenia.length == 0 || rolSeleccionado == null) {
            System.out.println("Unos de los caracteres es null");
            return;
        }

        // Convertir el valor seleccionado a Rol (enum)
        Rol rol;
        try {
            rol = Rol.valueOf(rolSeleccionado); // Convertimos el String a la enum Rol
        } catch (IllegalArgumentException e) {
            System.out.println("Rol no válido: " + rolSeleccionado);
            return; // Si el rol no es válido, salimos del método
        }

        try {

            Usuario nuevoUsuario = new Usuario(nombre, apellido, email, contrasenia, rol);

            //Llamamos al metodo registrarUsuario() DE UsuarioDAO
            usuarioDAO.registrarUsuario(nuevoUsuario);

            JOptionPane.showMessageDialog(null, "Usuario Regsitrado con exito");
            vista.dispose();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error registroo usuario" + ex.getMessage());
        }

    }
}
