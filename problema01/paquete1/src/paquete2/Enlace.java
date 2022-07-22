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
            String url = "jdbc:sqlite:bd/base01.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarTrabajador(Trabajador trabajadors) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Trabajador(cedula, nombres,correo ,sueldo ,mesSueldo)"
                    + "values ('%s','%s' ,'%s' ,'%.2f' ,'%s')",
                    trabajadors.obtenerCedula(),
                    trabajadors.obtenerNombres(),
                    trabajadors.obtenerCorreo(),
                    trabajadors.obtenerSueldo(),
                    trabajadors.obtenerMesSueldo());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: aca1");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Trabajador> obtenerDataTrabajador() {
        ArrayList<Trabajador> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement(); //statement permite ejecutar codigo SQL
            String data = "Select * from Trabajador;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Trabajador eltrabajador = new Trabajador(rs.getString("cedula"),//"nombre" hace referencia a la clase de la tabla
                        rs.getString("nombres"),
                        rs.getString("correo"),
                        rs.getDouble("sueldo"),
                        rs.getString("mesSueldo"));
                lista.add(eltrabajador);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: aca2");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
