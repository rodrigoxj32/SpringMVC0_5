package aduana.modelo;
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipousuario generated by hbm2java
 */
public class Tipousuario  implements java.io.Serializable {


     private int idTipousuario;
     private String codigoTipousuario;
     private String nombreTipousuario;
     private String descripcioTipousuario;
     private Set usuarios = new HashSet(0);

    public Tipousuario() {
    }

	
    public Tipousuario(int idTipousuario, String codigoTipousuario, String nombreTipousuario, String descripcioTipousuario) {
        this.idTipousuario = idTipousuario;
        this.codigoTipousuario = codigoTipousuario;
        this.nombreTipousuario = nombreTipousuario;
        this.descripcioTipousuario = descripcioTipousuario;
    }
    public Tipousuario(int idTipousuario, String codigoTipousuario, String nombreTipousuario, String descripcioTipousuario, Set usuarios) {
       this.idTipousuario = idTipousuario;
       this.codigoTipousuario = codigoTipousuario;
       this.nombreTipousuario = nombreTipousuario;
       this.descripcioTipousuario = descripcioTipousuario;
       this.usuarios = usuarios;
    }
   
    public int getIdTipousuario() {
        return this.idTipousuario;
    }
    
    public void setIdTipousuario(int idTipousuario) {
        this.idTipousuario = idTipousuario;
    }
    public String getCodigoTipousuario() {
        return this.codigoTipousuario;
    }
    
    public void setCodigoTipousuario(String codigoTipousuario) {
        this.codigoTipousuario = codigoTipousuario;
    }
    public String getNombreTipousuario() {
        return this.nombreTipousuario;
    }
    
    public void setNombreTipousuario(String nombreTipousuario) {
        this.nombreTipousuario = nombreTipousuario;
    }
    public String getDescripcioTipousuario() {
        return this.descripcioTipousuario;
    }
    
    public void setDescripcioTipousuario(String descripcioTipousuario) {
        this.descripcioTipousuario = descripcioTipousuario;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


