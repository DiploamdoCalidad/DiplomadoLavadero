/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DEmpleado;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class NEmpleado {
    DEmpleado DatoEmpleado;

    public NEmpleado() {
    DatoEmpleado= new DEmpleado();
    }
    public boolean GuardarEmpleado(int ID,int CI,String NOMBRE,int TELEFONO,String DIRECCION,String DESCRIPCION){
       DatoEmpleado.setCI(CI);
       DatoEmpleado.setDESCRIPCION(DESCRIPCION);
       DatoEmpleado.setDIRECCION(DIRECCION);
       DatoEmpleado.setID(ID);
       DatoEmpleado.setNOMBRE(NOMBRE);
       DatoEmpleado.setTELEFONO(TELEFONO);
       return DatoEmpleado.GuardarEmpleado();
    }
    
    public boolean ModificarEmpleado(int ID,int CI,String NOMBRE,int TELEFONO,String DIRECCION,String DESCRIPCION){
       DatoEmpleado.setCI(CI);
       DatoEmpleado.setDESCRIPCION(DESCRIPCION);
       DatoEmpleado.setDIRECCION(DIRECCION);
       DatoEmpleado.setID(ID);
       DatoEmpleado.setNOMBRE(NOMBRE);
       DatoEmpleado.setTELEFONO(TELEFONO);
       return DatoEmpleado.ModificarEmpleado();
    }
    
    public boolean  EliminarEmpleado(int ID){
    DatoEmpleado.setID(ID);
    return DatoEmpleado.EliminarEmpleado();   
    }
    
    public DefaultTableModel getEmpleados(){
        return DatoEmpleado.getEmpleado();
    }
    
    
}
