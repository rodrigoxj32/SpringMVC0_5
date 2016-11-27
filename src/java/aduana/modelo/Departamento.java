package aduana.modelo;
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {


     private int idDept;
     private Pais pais;
     private String codigoDept;
     private String nombreDept;
     private Set municipios = new HashSet(0);

    public Departamento() {
    }

	
    public Departamento(int idDept, String codigoDept, String nombreDept) {
        this.idDept = idDept;
        this.codigoDept = codigoDept;
        this.nombreDept = nombreDept;
    }
    public Departamento(int idDept, Pais pais, String codigoDept, String nombreDept, Set municipios) {
       this.idDept = idDept;
       this.pais = pais;
       this.codigoDept = codigoDept;
       this.nombreDept = nombreDept;
       this.municipios = municipios;
    }
   
    public int getIdDept() {
        return this.idDept;
    }
    
    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public String getCodigoDept() {
        return this.codigoDept;
    }
    
    public void setCodigoDept(String codigoDept) {
        this.codigoDept = codigoDept;
    }
    public String getNombreDept() {
        return this.nombreDept;
    }
    
    public void setNombreDept(String nombreDept) {
        this.nombreDept = nombreDept;
    }
    public Set getMunicipios() {
        return this.municipios;
    }
    
    public void setMunicipios(Set municipios) {
        this.municipios = municipios;
    }




}


