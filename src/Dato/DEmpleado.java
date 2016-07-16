/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.sql.Statement;

/**
 *
 * @author Miguel
 */
public class DEmpleado {
    private Conexion con;
    private int ID;
    private int CI;
    private String NOMBRE;
    private int TELEFONO;
    private String DIRECCION;
    private String DESCRIPCION;

    public DEmpleado() {
     con=Conexion.getInstncia();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
    
     public void GuardarEmpleado(){
       Statement Consulta;
       String dato ="INSERT INTO EMPLEADOS VALUES("+String.valueOf(ID) +","+String.valueOf(CI) +",'"+NOMBRE+"',"+String.valueOf(TELEFONO) +",'"+DIRECCION+"','ASDAD',CURDATE(),CURDATE());";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA EMPLEADOO");

       }
    }
    
}
