/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

/**
 *
 * @author SALA I
 */
public class Trabajador {
    private String cedula; 
    private String nombres; 
    private String correo; 
    private double sueldo; 
    private String mesSueldo; 
    
    public  Trabajador(String c, String n, String co, double su, String msue){
        cedula = c; 
        nombres = n; 
        correo = co; 
        sueldo = su; 
        mesSueldo = msue; 
    }

    public String obtenerCedula() {
        return cedula;
    }

    public void establecerCedula(String cedula) {
        this.cedula = cedula;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public void establecerNombres(String nombres) {
        this.nombres = nombres;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void establecerCorreo(String correo) {
        this.correo = correo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public void establecerSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    public void establecerMesSueldo(String mesSueldo) {
        this.mesSueldo = mesSueldo;
    }
    
}
