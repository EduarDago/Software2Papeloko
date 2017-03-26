/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ConexionFrameworkBD;

import java.io.File;
import org.hibernate.SessionFactory;

/**
 *
 * @author EDUARD
 * Esta clase puede ser borrada, no se utiliza en ningun momento
 */
public class HibernateUtil {

    private  SessionFactory sessionFactory;
    
    public HibernateUtil() {
        sessionFactory = null;
    }
    
    public String getSessionFactory() {
        
        try{
            
            java.io.FileInputStream f1 = new java.io.FileInputStream(new File("../../RecursosLogicos/hibernate.cfg.xml"));
            java.io.InputStreamReader f2 = new java.io.InputStreamReader(f1);
            java.io.BufferedReader linea = new java.io.BufferedReader(f2);
            String contenido = ":) ";
            while (linea.ready()) {
                String linea_arch = linea.readLine();
                contenido = contenido + linea_arch + "\n";
            }
            linea.close();
            return contenido;
        }
        catch(Exception R){
            return getClass().getResource(".").getFile(); 
        }
            
    }
    
}
