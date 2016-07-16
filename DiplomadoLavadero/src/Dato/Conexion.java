/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class Conexion {
    private static String Servidor="jdbc:mysql://localhost:3306/diplomado";
    private static String user="root";
    private static String pass="";
    private static String driver="com.mysql.jdbc.Driver";
    private  Connection con; 
    
    private static Conexion instancia;
    
    private Conexion() {
        try
        {
            Class.forName(driver);
            con=(Connection) DriverManager.getConnection(Servidor, user, pass);
            System.out.println("conexion realizada con exito");
            

        }catch(Exception ee){
            System.out.println("conexion fallida");
        }   
    }
    
    public static synchronized Conexion getInstncia(){
        if(instancia==null){
            instancia= new Conexion();
        }
        return instancia;
    }
    
    
    public Connection getConexion(){
        
        return con;
    }
    
    public Connection cerrarConexion(){
        try {
            con.close();
            
             System.out.println("Cerrando conexion a ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con=null;
        return con;
    }
    
    
    public void Rollback(){
        try {
            con.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Commit(){
        try { 
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
