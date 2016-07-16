/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dato.DServicio;

/**
 *
 * @author Miguel
 */
public class NServicio {
    DServicio DatoServicio;

    public NServicio() {
    DatoServicio= new DServicio();
    }
    public boolean GuardarServicio(int ID,String NOMBRE,String DESCRIPCION,double precio){
       DatoServicio.setID(ID);
       DatoServicio.setDESCRIPCION(DESCRIPCION);
       DatoServicio.setNOMBRE(NOMBRE);
       DatoServicio.setPRECIO(precio);

       return DatoServicio.GuardarServicio();
    }
    
//    public boolean ModificarEmpleado(int ID,int CI,String NOMBRE,int TELEFONO,String DIRECCION,String DESCRIPCION){
//       DatoEmpleado.setCI(CI);
//       DatoEmpleado.setDESCRIPCION(DESCRIPCION);
//       DatoEmpleado.setDIRECCION(DIRECCION);
//       DatoEmpleado.setID(ID);
//       DatoEmpleado.setNOMBRE(NOMBRE);
//       DatoEmpleado.setTELEFONO(TELEFONO);
//       return DatoEmpleado.ModificarEmpleado();
//    }
//    
//    public boolean  EliminarEmpleado(int ID){
//    //DatoEmpleado.setID(ID);
//    return DatoEmpleado.EliminarEmpleado();   
//    }
    
}
