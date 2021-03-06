package aduana.modelo;
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipotransporte generated by hbm2java
 */
public class Tipotransporte  implements java.io.Serializable {


     private int idTipotrans;
     private String clasificacionTipotrans;
     private double pesoTipotrans;
     private Set<Transporte> transportes = new HashSet<Transporte>(0);

    public Tipotransporte() {
    }

	
    public Tipotransporte(int idTipotrans, String clasificacionTipotrans, double pesoTipotrans) {
        this.idTipotrans = idTipotrans;
        this.clasificacionTipotrans = clasificacionTipotrans;
        this.pesoTipotrans = pesoTipotrans;
    }
    public Tipotransporte(int idTipotrans, String clasificacionTipotrans, double pesoTipotrans, Set<Transporte> transportes) {
       this.idTipotrans = idTipotrans;
       this.clasificacionTipotrans = clasificacionTipotrans;
       this.pesoTipotrans = pesoTipotrans;
       this.transportes = transportes;
    }
   
    public int getIdTipotrans() {
        return this.idTipotrans;
    }
    
    public void setIdTipotrans(int idTipotrans) {
        this.idTipotrans = idTipotrans;
    }
    public String getClasificacionTipotrans() {
        return this.clasificacionTipotrans;
    }
    
    public void setClasificacionTipotrans(String clasificacionTipotrans) {
        this.clasificacionTipotrans = clasificacionTipotrans;
    }
    public double getPesoTipotrans() {
        return this.pesoTipotrans;
    }
    
    public void setPesoTipotrans(double pesoTipotrans) {
        this.pesoTipotrans = pesoTipotrans;
    }
    public Set<Transporte> getTransportes() {
        return this.transportes;
    }
    
    public void setTransportes(Set<Transporte> transportes) {
        this.transportes = transportes;
    }




}


