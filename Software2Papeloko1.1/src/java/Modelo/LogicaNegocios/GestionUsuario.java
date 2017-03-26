/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.LogicaNegocios;

import Modelo.ClasesFramework.Usuarios;
import Modelo.ConexionFrameworkBD.NewHibernateUtil;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Esta Clase se encarga de la parte de gestion de Usuarios ( Agregar Adiciona Eliminar Consultar)
 * @author Eduar Ortega
 * @version 12/03/2017
 */

public class GestionUsuario {

    Session session = null;

    /**
     * @see Gestion Usuarios
    Cosntructor
    */
    
    public GestionUsuario() {
        
        
    }
    
    /**
    * Metodo ingresarUsuario se encarga de agregar un nuevo ususario en la base de datos
    * @param id Identificador del usuario
    * @param nombre Nombre del usuario
    * @param apellido Apellido del usuario  
    * @param rol Rol al que pertenece 
    * @param credencial  Credencial de ingreso al sistema
    */
    
    public void ingresarUsuario(int id, String nombre, String apellido, String rol, String credencial) throws Exception
    {
        Usuarios ser = new Usuarios(id, nombre, apellido, rol, credencial);
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        
        sf = NewHibernateUtil.getSessionFactory();
        s = sf.openSession();
        t = s.beginTransaction();
        s.save(ser);
        
        t.commit();
        s.close();
      
    }
    
     /**
    * Metodo consultarUsuarioCedula se encraga de buscar un usuario en la base de datos
    * @param id Identificador del usuario
    * @return Usuario
    */
    
    
    public Usuarios consultarUsuarioId(int id) 
    {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Usuarios ser = (Usuarios) s.get(Usuarios.class, id);
        s.close();
        return ser;
        
    }

     /**
    * Este metodo se encarga de eliminar un usuario de la base de datos 
    * @param id Identificador del usuario
    * @param nombre
    * @param apellido
    * @param rol
    * @param credenciales
    */
    
    
    public void eliminarUsuario(int id,String nombre,String apellido, String rol,String credenciales) 
    {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Usuarios U = new Usuarios(id, nombre, apellido, rol, credenciales);
        s.delete(U);
        /*
        Query q = s.createQuery("delete from Clientes where cedula = :cedula");
        q.setInteger("id", id);
        q.executeUpdate();
        */
        t.commit();
        s.close();
    }

    /**
    * metodo actualizarCliente se encarga de actualizar el cliente 
    * @param id Identificador del usuario
    * @param nombre Nombre del usuario
    * @param apellido Apellido del usuario  
    * @param rol Rol al que pertenece 
    * @param credencial  Credencial de ingreso al sistema
    * @return Uuario Actualizado
    */
    
    
    public Usuarios actualizarCliente(int id, String nombre, String apellido, String rol, String credencial) 
    {
        
        SessionFactory sf = NewHibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Usuarios u = new Usuarios(id, nombre, apellido, rol, credencial);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }
    
    //No usado por el Momento
    /*
    public java.util.List<Usuarios> obtenerClientes() {
        java.util.List<Usuarios> lista = new java.util.LinkedList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Clientes");
        lista = q.list();
        s.close();

        return lista;
    }

    */
}
