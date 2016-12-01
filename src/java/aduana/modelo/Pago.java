package aduana.modelo;
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pago generated by hbm2java
 */
public class Pago  implements java.io.Serializable {


     private int idPago;
     private Catalogopagos catalogopagos;
     private Pais pais;
     private Tipopago tipopago;
     private String codigoPago;
     private String precioPago;
     private Set<Formularioexportacion> formularioexportacions = new HashSet<Formularioexportacion>(0);

    public Pago() {
    }

	
    public Pago(int idPago, Catalogopagos catalogopagos, Pais pais, Tipopago tipopago, String codigoPago, String precioPago) {
        this.idPago = idPago;
        this.catalogopagos = catalogopagos;
        this.pais = pais;
        this.tipopago = tipopago;
        this.codigoPago = codigoPago;
        this.precioPago = precioPago;
    }
    public Pago(int idPago, Catalogopagos catalogopagos, Pais pais, Tipopago tipopago, String codigoPago, String precioPago, Set<Formularioexportacion> formularioexportacions) {
       this.idPago = idPago;
       this.catalogopagos = catalogopagos;
       this.pais = pais;
       this.tipopago = tipopago;
       this.codigoPago = codigoPago;
       this.precioPago = precioPago;
       this.formularioexportacions = formularioexportacions;
    }
   
    public int getIdPago() {
        return this.idPago;
    }
    
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    public Catalogopagos getCatalogopagos() {
        return this.catalogopagos;
    }
    
    public void setCatalogopagos(Catalogopagos catalogopagos) {
        this.catalogopagos = catalogopagos;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public Tipopago getTipopago() {
        return this.tipopago;
    }
    
    public void setTipopago(Tipopago tipopago) {
        this.tipopago = tipopago;
    }
    public String getCodigoPago() {
        return this.codigoPago;
    }
    
    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }
    public String getPrecioPago() {
        return this.precioPago;
    }
    
    public void setPrecioPago(String precioPago) {
        this.precioPago = precioPago;
    }
    public Set<Formularioexportacion> getFormularioexportacions() {
        return this.formularioexportacions;
    }
    
    public void setFormularioexportacions(Set<Formularioexportacion> formularioexportacions) {
        this.formularioexportacions = formularioexportacions;
    }




}


