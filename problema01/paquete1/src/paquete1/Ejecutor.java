/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete1;

import java.util.Scanner;
import paquete2.Enlace;
import paquete2.Trabajador;

/**
 *
 * @author SALA I
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Enlace c = new Enlace();
        // TODO code application logic here
        boolean bandera = true;

        while (bandera) {
            System.out.println("Ingrese la cedula del Trabajador");
            String cedula = entrada.nextLine();
            System.out.println("Ingres el nombre");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese el Correo");
            String correo = entrada.nextLine();
            System.out.println("Ingrese el Sueldo");
            double sueldo = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Ingrese el mes del Sueldo");
            String mes = entrada.nextLine();
            
            Trabajador tra1 = new Trabajador(cedula,nombre,correo,sueldo,mes);
            c.insertarTrabajador(tra1);
            
            System.out.println("Ingrese (SI) para salir del programa");
            String condicion = entrada.nextLine();            
            if (condicion.equals("SI")) {
                bandera = false;
            }
        }      
    }

}
