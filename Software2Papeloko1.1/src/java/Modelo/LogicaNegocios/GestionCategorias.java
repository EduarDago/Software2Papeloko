/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.LogicaNegocios;

import Modelo.ClasesFramework.Categorias;
import Modelo.ConexionFrameworkBD.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Esta Clase se encarga de la parte de gestion de Categorias ( Agregar Adiciona
 * Eliminar Consultar)
 *
 * @author Michael Marin Valencia
 * @version 12/03/2017
 */
public class GestionCategorias {

    Session session = null;

    /*
        Cosntructor
     */
    public GestionCategorias() {

    }

    /**
     * Metodo ingresarCategoria se encarga de agregar una nueva categoria en la
     * base de datos
     *
     * @param id Identificador de la categoria
     * @param nombre Nombre de la categoria
     * @param descripcion descripcion de la categoria
     * @param credencial Credencial de ingreso al sistema
     */
    public void ingresarCategoria(int id, String nombre, String descripcion) throws Exception {
                
        Categorias ser = new Categorias(id, nombre, descripcion);
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
     * Metodo consultarCategoriaId se encarga de buscar una categoria en la base
     * de datos
     *
     * @param id Identificador de la categoria
     * @return Categoria
     */
    public Categorias consultarCategoriaId(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Categorias ser = (Categorias) s.get(Categorias.class, id);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    /**
     * Este metodo se encarga de eliminar una categoria de la base de datos
     *
     * @param id Identificador de la categoria
     */
    public void eliminarCategoria(Integer id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Categorias Categoria = (Categorias)s.load(Categorias.class, id);
        //Query q = s.createQuery("DELETE FROM categorias WHERE id = :id");
        //q.setParameter("id", id);
        //q.executeUpdate();
        s.delete(Categoria);
        t.commit();
        s.close();
    }

    /**
     * metodo actualizarCategorias se encarga de actualizar la categoria
     *
     * @param id Identificador de la categoria
     * @param nombre Nombre de la categoria
     * @param descripcion descripcion de la categoria
     * @return Categoria Actualizado
     */
    public Categorias actualizarCategorias(int id, String nombre, String descripcion) {

        SessionFactory sf = NewHibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Categorias u = new Categorias(id, nombre, descripcion);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

}
