package aduana.modelo;
<<<<<<< HEAD
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1
=======
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3


import java.util.HashSet;
import java.util.Set;

/**
 * Catalogopagos generated by hbm2java
 */
public class Catalogopagos  implements java.io.Serializable {


     private int idCatpagos;
     private String codigoCatpagos;
     private String clasificacionCatpagos;
<<<<<<< HEAD
     private Set<Pago> pagos = new HashSet<Pago>(0);
=======
     private Set pagos = new HashSet(0);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3

    public Catalogopagos() {
    }

	
    public Catalogopagos(int idCatpagos, String codigoCatpagos, String clasificacionCatpagos) {
        this.idCatpagos = idCatpagos;
        this.codigoCatpagos = codigoCatpagos;
        this.clasificacionCatpagos = clasificacionCatpagos;
    }
<<<<<<< HEAD
    public Catalogopagos(int idCatpagos, String codigoCatpagos, String clasificacionCatpagos, Set<Pago> pagos) {
=======
    public Catalogopagos(int idCatpagos, String codigoCatpagos, String clasificacionCatpagos, Set pagos) {
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
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
<<<<<<< HEAD
    public Set<Pago> getPagos() {
        return this.pagos;
    }
    
    public void setPagos(Set<Pago> pagos) {
=======
    public Set getPagos() {
        return this.pagos;
    }
    
    public void setPagos(Set pagos) {
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        this.pagos = pagos;
    }




}


