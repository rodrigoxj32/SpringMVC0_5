package aduana.modelo;
// Generated 11-20-2016 10:33:46 AM by Hibernate Tools 4.3.1



/**
 * Aduana generated by hbm2java
 */
public class Aduana  implements java.io.Serializable {


     private int idAduana;
     private Pais pais;
     private String nombreAduana;
     private String codigoAduana;

    public Aduana() {
    }

	
    public Aduana(int idAduana, String nombreAduana, String codigoAduana) {
        this.idAduana = idAduana;
        this.nombreAduana = nombreAduana;
        this.codigoAduana = codigoAduana;
    }
    public Aduana(int idAduana, Pais pais, String nombreAduana, String codigoAduana) {
       this.idAduana = idAduana;
       this.pais = pais;
       this.nombreAduana = nombreAduana;
       this.codigoAduana = codigoAduana;
    }
   
    public int getIdAduana() {
        return this.idAduana;
    }
    
    public void setIdAduana(int idAduana) {
        this.idAduana = idAduana;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public String getNombreAduana() {
        return this.nombreAduana;
    }
    
    public void setNombreAduana(String nombreAduana) {
        this.nombreAduana = nombreAduana;
    }
    public String getCodigoAduana() {
        return this.codigoAduana;
    }
    
    public void setCodigoAduana(String codigoAduana) {
        this.codigoAduana = codigoAduana;
    }




}


