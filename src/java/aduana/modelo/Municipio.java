package aduana.modelo;
<<<<<<< HEAD
// Generated 11-30-2016 03:24:13 PM by Hibernate Tools 4.3.1
=======
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3



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

<<<<<<< HEAD
=======
	
    public Municipio(int idMunicipio, String nombreMunicipio, String codigoMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.codigoMunicipio = codigoMunicipio;
    }
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
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


