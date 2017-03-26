/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.PeticionesJs;

import Modelo.ClasesFramework.Stock;
import Modelo.LogicaNegocios.GestionStock;
import com.google.gson.Gson;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EDUARD
 */
//@WebServlet(name = "UsuariosControlador", urlPatterns
//        = {
//            "/UsuariosControlador"
//        })

public class PeticionesJsStock extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private GestionStock Stock;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String Operacion = request.getParameter("Operacion");
        this.Stock = new GestionStock();

        if( Operacion.equals("Agregar") ){
            try {
               
                this.Stock.ingresarStock(Integer.parseInt( request.getParameter("Id") ), request.getParameter("Nombre"), request.getParameter("Estado"));
            //response.getWriter().print(this.Usuario.getUsuariosID(1));*/
                response.getWriter().print("Exito");
            } 
            catch (Exception e) {
                response.getWriter().print("null");
            }
            

            //Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        else if( Operacion.equals("Actualizar") ){
            try{
                
                String Id = request.getParameter("Id");
                Id = Id.trim();
                Stock stock = this.Stock.actualizarstock(Integer.parseInt( Id ), request.getParameter("Nombre"), request.getParameter("Estado"));
//                if( User != null){
//                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
//                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
//                }
                Gson json = new Gson();
                String Json = json.toJson(stock);
                
                response.getWriter().print(Json);
                
            }catch(NumberFormatException e){
                response.getWriter().print("null");
            }
        }
        else if( Operacion.equals("Eliminar") ){
                        try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                this.Stock.eliminarStock(Integer.parseInt( Id ));
                response.getWriter().print(" Stock Eliminado");
            }
            catch(Exception E){
                response.getWriter().print("null");
            }
        }
        else if( Operacion.equals("Consultar") ){
            try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                
                Stock Stk = this.Stock.consultarStockId(Integer.parseInt(Id));
                /*if( User != null){
                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
                }*/
                Gson json = new Gson();
                
                String J = json.toJson(Stk);
                response.getWriter().print(J);
                
            }catch(NumberFormatException e){
                response.getWriter().print("null");
            }
            
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
            Logger.getLogger(PeticionesJsStock.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionesJsStock.class.getName()).log(Level.SEVERE, null, ex);
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
