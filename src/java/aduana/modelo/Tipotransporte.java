package aduana.modelo;
<<<<<<< HEAD
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1
=======
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3


import java.util.HashSet;
import java.util.Set;

/**
 * Tipotransporte generated by hbm2java
 */
public class Tipotransporte  implements java.io.Serializable {


     private int idTipotrans;
     private String clasificacionTipotrans;
     private double pesoTipotrans;
<<<<<<< HEAD
     private Set<Transporte> transportes = new HashSet<Transporte>(0);
=======
     private Set transportes = new HashSet(0);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3

    public Tipotransporte() {
    }

	
    public Tipotransporte(int idTipotrans, String clasificacionTipotrans, double pesoTipotrans) {
        this.idTipotrans = idTipotrans;
        this.clasificacionTipotrans = clasificacionTipotrans;
        this.pesoTipotrans = pesoTipotrans;
    }
<<<<<<< HEAD
    public Tipotransporte(int idTipotrans, String clasificacionTipotrans, double pesoTipotrans, Set<Transporte> transportes) {
=======
    public Tipotransporte(int idTipotrans, String clasificacionTipotrans, double pesoTipotrans, Set transportes) {
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
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
<<<<<<< HEAD
    public Set<Transporte> getTransportes() {
        return this.transportes;
    }
    
    public void setTransportes(Set<Transporte> transportes) {
=======
    public Set getTransportes() {
        return this.transportes;
    }
    
    public void setTransportes(Set transportes) {
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        this.transportes = transportes;
    }




}


