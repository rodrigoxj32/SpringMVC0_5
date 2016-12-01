package aduana.modelo;
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Catalogopagos generated by hbm2java
 */
public class Catalogopagos  implements java.io.Serializable {


     private int idCatpagos;
     private String codigoCatpagos;
     private String clasificacionCatpagos;
     private Set<Pago> pagos = new HashSet<Pago>(0);

    public Catalogopagos() {
    }

	
    public Catalogopagos(int idCatpagos, String codigoCatpagos, String clasificacionCatpagos) {
        this.idCatpagos = idCatpagos;
        this.codigoCatpagos = codigoCatpagos;
        this.clasificacionCatpagos = clasificacionCatpagos;
    }
    public Catalogopagos(int idCatpagos, String codigoCatpagos, String clasificacionCatpagos, Set<Pago> pagos) {
       this.idCatpagos = idCatpagos;
       this.codigoCatpagos = codigoCatpagos;
       this.clasificacionCatpagos = clasificacionCatpagos;
       this.pagos = pagos;
    }
   
    public int getIdCatpagos() {
        return this.idCatpagos;
    }
    
    public void setIdCatpagos(int idCatpagos) {
        this.idCatpagos = idCatpagos;
    }
    public String getCodigoCatpagos() {
        return this.codigoCatpagos;
    }
    
    public void setCodigoCatpagos(String codigoCatpagos) {
        this.codigoCatpagos = codigoCatpagos;
    }
    public String getClasificacionCatpagos() {
        return this.clasificacionCatpagos;
    }
    
    public void setClasificacionCatpagos(String clasificacionCatpagos) {
        this.clasificacionCatpagos = clasificacionCatpagos;
    }
    public Set<Pago> getPagos() {
        return this.pagos;
    }
    
    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }




}


