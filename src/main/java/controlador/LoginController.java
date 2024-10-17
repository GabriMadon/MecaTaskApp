/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.dao.UsuarioDAO;
import modelo.dao.VehiculoDAO;
import modelo.dao.entidades.Usuario;
import modelo.dao.entidades.Usuario.Rol;
import vista.AdmiVista;
import vista.LoginVista;
import vista.TecnicoVsita;

/**
 *
 * @author juand
 */
public class LoginController {

    //Atributos
    private UsuarioDAO usuarioDAO;
    private LoginVista vista;
    VehiculoDAO vehiculoDAO;
    RegistroVehiculoController registro;

   

    //Constructor

    public LoginController(LoginVista vista, UsuarioDAO usuarioDAO) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;

    }

    //Metodos
    public void iniciarSesion() {

        String email = vista.getTxtEmail().getText();
        String contrasenia = new String(vista.getjPassword().getPassword());
        
        //Validacion para email
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "Email no puede estar vacío");
            return;//Sale del metodo si hay un error
        }
        
        //if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
           // JOptionPane.showMessageDialog(null, "El email ingresado no es valido");
        
        //}
        
        //Validacion para contraseña
        if(contrasenia.isEmpty()){
            JOptionPane.showMessageDialog(null, "Contraseña no puede estra vacio");
            return;
        }
        
        //if(contrasenia.length()<8){
            //JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres");
        //}

        //System.out.println("Soy email : " + email);
        //System.out.println("Soy contraseña: " + contrasenia);

        try {
            //loginUsuario verifica si el usuario existe en la DB - parametros del formulario LoginVista
            Usuario usuario = usuarioDAO.loginUsuario(email, contrasenia);
            // si se encuentra devuelve un objeto usuario
            if (usuario != null && new String(usuario.getContrasenia()).equals(contrasenia)) {

                final JOptionPane optionPane = new JOptionPane("¡Bienvenido! Tu sesión ha iniciado con éxito...", JOptionPane.INFORMATION_MESSAGE);
                final JDialog dialog = optionPane.createDialog("Exito");//mensjae ventana
                dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                

                Timer timer = new Timer(2000, e -> dialog.dispose());
                timer = new Timer(1500, e -> dialog.dispose());
                timer.start();
                
                dialog.setVisible(true);
                
                vista.dispose();
                //Pantallas segun su rol
                if (usuario != null) {
                    if (usuario.getRol() == Rol.administrador) {
                        System.out.println("Pantalla ADMINISTRADOR");
                        AdmiVista admiVista = new AdmiVista(vehiculoDAO);
                        
                        admiVista.setLocationRelativeTo(null);
                        admiVista.setVisible(true);
                        
                        
                    } else if (usuario.getRol() == Rol.tecnico) {
                        System.out.println("PAntalla TECNICO");
                        TecnicoVsita tecnicoVsita = new TecnicoVsita();
                        
                        tecnicoVsita.setLocationRelativeTo(null);
                        tecnicoVsita.setVisible(true);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Email y contraseña incorrectos");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "LOGIN Error al acceder a la DB : " + ex.getMessage());
        }
    }
}
