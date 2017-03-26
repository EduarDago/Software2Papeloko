/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ConexionFrameworkBD;

import java.io.File;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author EDUARD
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static
    {
        try
        {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure("/RecursosLogicos/hibernate.cfg.xml").buildSessionFactory();
           //h = "";
            //sessionFactory = null;
        } catch (Throwable ex)
        {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed................................!!!!!!!!!!!!!!!!!!!!............." + ex.toString());
            throw new ExceptionInInitializerError(ex);
            //h = ex.toString();
        }
    }
    
    public static SessionFactory getSessionFactory() {

          return sessionFactory;
    }
}
