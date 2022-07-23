/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SALA I
 */
public class Enlace {
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.base";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
        public ArrayList<Estudiante> obtenerDataEstudiante() {  
        ArrayList<Estudiante> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Estudiante;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Estudiante estu = new Estudiante();
                estu.establecerNombre(rs.getString("nombre"));
                estu.establecerApellido(rs.getString("apellido"));
                estu.establecerCalificacion1(rs.getDouble("calificacion1"));
                estu.establecerCalificacion2(rs.getDouble("calificacion2"));
                estu.establecerCalificacion3(rs.getDouble("calificacion3"));
                lista.add(estu);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
}
