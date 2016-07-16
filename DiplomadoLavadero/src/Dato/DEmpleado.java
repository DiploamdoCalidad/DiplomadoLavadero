/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit;

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
    
     public Boolean GuardarEmpleado(){
       Statement Consulta;
       String dato ="INSERT INTO EMPLEADOS VALUES("+String.valueOf(ID) +","+String.valueOf(CI) +",'"+NOMBRE+"',"+String.valueOf(TELEFONO) +",'"+DIRECCION+"','"+DESCRIPCION+"',NOW(),NOW());";
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
       String dato ="update empleados set ci="+String.valueOf(CI) +",nombre='"+NOMBRE+"',telefono="+String.valueOf(TELEFONO) +",direccion='"+DIRECCION+"', descripcion='"+DESCRIPCION+"',updated_at=now() where id="+String.valueOf(ID) +";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
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
     
     public DefaultTableModel getEmpleado(){
         String[] columnNames = {"ID","CI","NOMBRE","TELEFONO","DIRECCION","DESCRIPCION"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from empleados;";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                tabla.setRowCount(tabla.getRowCount()+1);
                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultado.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultado.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultado.getObject(5).toString(), i, 4);
                tabla.setValueAt(resultado.getObject(6).toString(), i, 5);
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA GENERO");
       } 
      
      return tabla;
     }
     
    
}
