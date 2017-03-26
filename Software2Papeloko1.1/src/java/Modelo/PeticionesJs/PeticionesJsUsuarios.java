/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.PeticionesJs;

import Modelo.ClasesFramework.Usuarios;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.LogicaNegocios.GestionUsuario;
import com.google.gson.Gson;


/**
 * Esta Clase se encarga de la comunicación entre los controladores y la gestion de Ususarios en al Modelo
 * @author Eduar Ortega
 * @version 13/03/2017
 */

/*
Permite establecer una coneccion con el controlador
*/

//@WebServlet(name = "PeticionesJsUsuarios", urlPatterns
//        = {
//            "/PeticionesJsUsuarios"
//        })

public class PeticionesJsUsuarios extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */  
    
    private GestionUsuario Usuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String Operacion = request.getParameter("Operacion");
        this.Usuario = new GestionUsuario();

        if( Operacion.equals("Agregar") ){
            try {
               
               this.Usuario.ingresarUsuario(Integer.parseInt( request.getParameter("Id") ), request.getParameter("Nombre"), request.getParameter("Apellido"),
                                        request.getParameter("Rol"), request.getParameter("Credencial"));
                
                response.getWriter().print("Se Agrego con Exito");
            } 
            catch (Exception e) {
                response.getWriter().print("null");
            }

        }
        else if( Operacion.equals("Actualizar") ){
            try{
                
                String Id = request.getParameter("Id");
                Id = Id.trim();
                Usuarios User = this.Usuario.actualizarCliente(Integer.parseInt( request.getParameter("Id") ), request.getParameter("Nombre"), request.getParameter("Apellido"),
                                        request.getParameter("Rol"), request.getParameter("Credencial") );
//                if( User != null){
//                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
//                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
//                }
                Gson json = new Gson();
                String Json = json.toJson(User);
                
                response.getWriter().print(Json);
                
            }catch(NumberFormatException e){
                response.getWriter().print("null");
            }
        }
        else if( Operacion.equals("Eliminar") ){
            try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                this.Usuario.eliminarUsuario(Integer.parseInt( request.getParameter("Id") ), request.getParameter("Nombre"), request.getParameter("Apellido"),
                                        request.getParameter("Rol"), request.getParameter("Credencial") );
                response.getWriter().print(" Usuario Eliminado");
            }
            catch(Exception E){
                response.getWriter().print("null");
            }
        }
        else if( Operacion.equals("Consultar") ){
            try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                
                Usuarios User = this.Usuario.consultarUsuarioId( Integer.parseInt(Id));
                /*if( User != null){
                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
                }*/
                Gson json = new Gson();
                
                String J = json.toJson(User);
                response.getWriter().print(J);
                
            }catch(NumberFormatException e){
                response.getWriter().print("null");
            }
        }
        else{

        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionesJsUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionesJsUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
