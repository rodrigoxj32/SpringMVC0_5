package aduana.modelo;
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1



/**
 * Municipio generated by hbm2java
 */
public class Municipio  implements java.io.Serializable {


     private int idMunicipio;
     private Departamento departamento;
     private String nombreMunicipio;
     private String codigoMunicipio;

    public Municipio() {
    }

	
    public Municipio(int idMunicipio, String nombreMunicipio, String codigoMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.codigoMunicipio = codigoMunicipio;
    }
    public Municipio(int idMunicipio, Departamento departamento, String nombreMunicipio, String codigoMunicipio) {
       this.idMunicipio = idMunicipio;
       this.departamento = departamento;
       this.nombreMunicipio = nombreMunicipio;
       this.codigoMunicipio = codigoMunicipio;
    }
   
    public int getIdMunicipio() {
        return this.idMunicipio;
    }
    
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }
    
    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
    public String getCodigoMunicipio() {
        return this.codigoMunicipio;
    }
    
    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }




}


