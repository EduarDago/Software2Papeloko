/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.LogicaNegocios;

import Modelo.ClasesFramework.Stock;
import Modelo.ConexionFrameworkBD.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EDUARD
 */
public class GestionStock {

    Session session = null;

    public GestionStock() {
        
        
    }

    
    public void ingresarStock(int id, String nombre, String estado) throws Exception{
        Stock ser = new Stock(id, nombre, estado);
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

    public Stock consultarStockId(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Stock ser = (Stock) s.get(Stock.class, id);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarStock(int id) {
        java.util.List<Stock> lista = new java.util.LinkedList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Stock Stock = (Stock) s.get(Stock.class, id);
//        q.setInteger("id", id);
//        q.executeUpdate();
        s.delete(Stock);
        t.commit();
        s.close();

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session s = sf.openSession();
//        Servicios ser = consultarServicioPorId(id);
//        System.out.println("el servicio es " + ser.getNombre());
//        System.out.println("el servicio es " + ser.getId());
//        s.delete(ser);
//        s.close();
    }

    public Stock actualizarstock(int id, String nombre, String estado) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Stock u = new Stock(id, nombre, estado);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public java.util.List<Stock> obtenerClientes() {
        java.util.List<Stock> lista = new java.util.LinkedList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from stock");
        lista = q.list();
        s.close();

        return lista;
    }

    
}
