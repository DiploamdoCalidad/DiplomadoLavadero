/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.sql.Statement;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Miguel
 */
public class DServicio {
    private Conexion con;
    private int ID;
    private String NOMBRE;
    private String DESCRIPCION;
    private double PRECIO;
   

    public DServicio() {
     con=Conexion.getInstncia();
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }

    
     public Boolean GuardarServicio(){
       Statement Consulta;
       String dato ="INSERT INTO SERVICIOS VALUES("+String.valueOf(ID) +",'"+NOMBRE+"','"+DESCRIPCION+"',"+Double.valueOf(PRECIO)+",NOW(),NOW());";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
           return true;
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA EMPLEADOO");
           return false;
       }
    }
     
     public Boolean ModificarEmpleado(){
       Statement Consulta;
      // String dato ="update empleados set ci="+String.valueOf(CI) +",nombre='"+NOMBRE+"',telefono="+String.valueOf(TELEFONO) +",direccion='"+DIRECCION+"', descripcion='"+DESCRIPCION+"',updated_at=now() where id="+String.valueOf(ID) +";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
       //    Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
           return true;
       } catch (Exception e) {
           System.out.println("no se puede MODIFICARON TABLA EMPLEADOO");
           return false;
       }
    }
     
     public boolean EliminarEmpleado(){
       Statement Consulta;
       String dato ="DELETE FROM EMPLEADOS where id="+String.valueOf(ID) +";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
           return true;
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabla Empleado");
           return false;
       }
    }
     
    
}
