package Modelo.ClasesFramework;
// Generated 17-mar-2017 18:55:03 by Hibernate Tools 4.3.1



/**
 * Categorias generated by hbm2java
 */
public class Categorias  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String descripcion;

    public Categorias() {
    }

	
    public Categorias(int id) {
        this.id = id;
    }
    public Categorias(int id, String nombre, String descripcion) {
       this.id = id;
       this.nombre = nombre;
       this.descripcion = descripcion;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

