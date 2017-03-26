/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.PeticionesJs;

import Modelo.ClasesFramework.Categorias;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.LogicaNegocios.GestionCategorias;
import com.google.gson.Gson;

/**
 * Esta Clase se encarga de la comunicación entre los controladores y la gestion
 * de Categorias en el Modelo
 *
 * @author Michael Marin Valencia
 * @version 12/03/2017
 */

/*
Permite establecer una conexion con el controlador
Editado en web.xml *
@WebServlet(name = "PeticionesJsCategorias", urlPatterns
        = {
            "/PeticionesJsCategorias"
        })
*/
public class PeticionesJsCategorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private GestionCategorias Categoria;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        response.setContentType("text/html;charset=UTF-8");

        String Operacion = request.getParameter("Operacion");
        this.Categoria = new GestionCategorias();

        if (Operacion.equals("Agregar"))
        {
            try {
                String Id = request.getParameter("Id");
                Id = Id.trim();
                this.Categoria.ingresarCategoria(Integer.parseInt( Id ), request.getParameter("Nombre"), request.getParameter("Descripcion"));

                response.getWriter().print("Se Agrego con Exito !");
            } catch (Exception e) {
                response.getWriter().print("null");
            }

        } 
        else if (Operacion.equals("Actualizar")) 
        {
            try{
                
                String Id = request.getParameter("Id");
                Id = Id.trim();
                Categorias User = this.Categoria.actualizarCategorias(Integer.parseInt( Id ), request.getParameter("Nombre"), request.getParameter("Descripcion"));
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
        else if (Operacion.equals("Eliminar")) 
        {
            try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                this.Categoria.eliminarCategoria(Integer.parseInt( Id ));
                response.getWriter().print(" Cetgoria Eliminada");
            }
            catch(Exception E){
                response.getWriter().print("null");
            }
        }
        else if (Operacion.equals("Consultar")) 
        {
            try{
                String Id = request.getParameter("Id");
                Id = Id.trim();
                
                Categorias Cat = this.Categoria.consultarCategoriaId(Integer.parseInt(Id));
                /*if( User != null){
                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
                }*/
                Gson json = new Gson();
                
                String J = json.toJson(Cat);
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
            Logger.getLogger(PeticionesJsCategorias.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionesJsCategorias.class.getName()).log(Level.SEVERE, null, ex);
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
