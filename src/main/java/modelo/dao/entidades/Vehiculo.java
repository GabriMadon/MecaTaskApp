/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao.entidades;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {
    //Atributos
    private String marca;
    private String modelo;
    private int anio;
    private String placa;
    
    //Constructor
    
    public Vehiculo(String mara, String modelo, int anio, String placa){
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
        this.placa=placa;
        
    }
    
    
    //Getters And Setteres

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
}
