/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao.entidades;

/**
 *
 * @author juand
 */
public class Usuario {
    //Atributos
    private int id ;
    private String nombre;
    private String apellido;
    private String email;
    private char [] contrasenia;
    private Rol rol;
    
    //Dato Especial
    public enum Rol{
        administrador,
        tecnico,
    }
    
    //Constructor
    public Usuario(int id, String nombre, String apellido, String email,
            char [] contrasenia,Rol rol )
    {
        this.id = id;
        this.nombre= nombre;
        this.apellido= apellido;
        this.email=email;
        this.contrasenia=contrasenia;
        this.rol=rol;
    }
    

    public Usuario(String nombre, String apellido, String email,
            char [] contrasenia, Rol rol)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contrasenia=contrasenia;
        this.rol=rol;
        
    
    }
    

    public Usuario(){
    
    }
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(char[] contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
}
