package Modelo.ClasesFramework;
// Generated mar 21, 2017 2:41:24 p.m. by Hibernate Tools 4.3.1



/**
 * Stock generated by hbm2java
 */
public class Stock  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String estado;

    public Stock() {
    }

	
    public Stock(int id) {
        this.id = id;
    }
    public Stock(int id, String nombre, String estado) {
       this.id = id;
       this.nombre = nombre;
       this.estado = estado;
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}

