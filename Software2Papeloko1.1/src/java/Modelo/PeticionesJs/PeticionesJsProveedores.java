
package Modelo.PeticionesJs;

import Modelo.ClasesFramework.Proveedores;
import Modelo.LogicaNegocios.GestionProveedores;
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
 * Esta Clase se encarga de la comunicación entre el controlador de Proovedores y la gestion de proovedores en el Modelo
 * @author Sebastian Diaz
 * @version 12/03/2017
 */

/*
Permite establecer una conexion con el controlador
*/

//@WebServlet(name = "PeticionesJsProveedores", urlPatterns
//        = {
//            "/PeticionesJsProveedores"
//        })

public class PeticionesJsProveedores extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */  
    
    private GestionProveedores proveedor;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String Operacion = request.getParameter("Operacion");
        this.proveedor = new GestionProveedores();

        if( Operacion.equals("Agregar") ){
            try {
                String tel = request.getParameter("telefono");
                tel = tel.trim();
                
                this.proveedor.ingresarProveedor(request.getParameter("nit"), request.getParameter("nombre"), Integer.parseInt( tel ),
                                    request.getParameter("direccion"));
                
                response.getWriter().print("Se Agrego con Exito"); 
            } 
            catch (Exception e) {
                response.getWriter().print("null");
            }
            
        }
        else if( Operacion.equals("Actualizar") )
        {
            try{
              
                String tel = request.getParameter("telefono");
                tel = tel.trim();
                
                Proveedores User = this.proveedor.actualizarProveedor(request.getParameter("nit"), request.getParameter("nombre"), 
                                    Integer.parseInt(tel), request.getParameter("direccion"));
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
                this.proveedor.eliminarProveedor(request.getParameter("nit"));
                response.getWriter().print(" Proveedor Eliminado");
            }
            catch(Exception E){
                response.getWriter().print("null");
            }
        }
        else if( Operacion.equals("Consultar") ){
            try{
                
                Proveedores Prov = this.proveedor.consultarProveedor(request.getParameter("nit"));
                /*if( User != null){
                    Json = "{\"Id\":\""+User.getId()+"\",\"Nombre\":\""+User.getNombre()+"\",\"Apellido\":\""
                           +User.getApellido()+"\",\"Rol\":\""+User.getRol()+"\","+"\"Credenciales\":\""+User.getCredenciales()+"\"}";
                }*/
                Gson json = new Gson();
                
                String J = json.toJson(Prov);
                response.getWriter().print(J);
                
            }catch(Exception e){
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
            Logger.getLogger(PeticionesJsProveedores.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionesJsProveedores.class.getName()).log(Level.SEVERE, null, ex);
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
