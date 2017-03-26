/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.LogicaNegocios;

import Modelo.ClasesFramework.Proveedores;
import Modelo.ConexionFrameworkBD.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Esta Clase se encarga de la parte de gestion de Proveedores ( Agregar Adiciona Eliminar Consultar)
 * @author Sebastian Diaz
 * @version 12/03/2017
 */

public class GestionProveedores {

    Session session = null;

    /*
        Cosntructor
    */
    
    public GestionProveedores() {
        
        
    }
    
    /**
    * Metodo ingresarProveedor se encarga de agregar un nuevo proveedor en la base de datos
    * @param id Identificador del proveedor
    * @param nombre 
    * @param telefono 
    * @param direccion 

    */
    
    public void ingresarProveedor(String nit, String nombre, int telefono, String direccion) throws Exception
    {
        Proveedores proveedor = new Proveedores(nit, nombre, telefono, direccion);
        SessionFactory seseionfactory = null;
        Transaction transaccion = null;
        Session sesion = null;
        
        seseionfactory = NewHibernateUtil.getSessionFactory();
        sesion = seseionfactory.openSession();
        transaccion = sesion.beginTransaction();
        sesion.save(proveedor);
        transaccion.commit();
        sesion.close();
      
    }
    
     /**
    * Metodo consultarProveedor se encraga de buscar un proveedor en la base de datos
    * @param nit Identificador del proveedor
    * @return Proovedor
    */
    
    
    public Proveedores consultarProveedor(String nit) 
    {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Proveedores ser = (Proveedores) s.get(Proveedores.class, nit);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

     /**
    * Este metodo se encarga de eliminar un proveedor de la base de datos 
    * @param nit Identificador del Proveedor
    */
    
    
    public void eliminarProveedor(String nit) 
    {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Proveedores Proveedor = (Proveedores)s.load(Proveedores.class, nit);
        s.delete(Proveedor);
        t.commit();
        s.close();
    }

      
        /**
    * Metodo ingresarProveedor se encarga de agregar un nuevo proveedor en la base de datos
    * @param id Identificador del proveedor
    * @param nombre 
    * @param telefono 
    * @param direccion 
    * @return Prooveedor actualizado

    */
    
    public Proveedores actualizarProveedor(String nit, String nombre, int telefono, String direccion) {
        
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Proveedores u = new Proveedores(nit, nombre, telefono, direccion);
            s.update(u);
            t.commit();
            s.close();
            return u;
        
    }

}
