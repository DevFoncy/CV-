/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.proyecto.model;

/**
 *
 * @author PC-TOSHIBA
 */
public class Institucion {
    private String ID_INSTITUCION;
    private String NOMBRE;
    private String CLASE;
    private String PAIS;

    /**
     * @return the ID_INSTITUCION
     */
    public String getID_INSTITUCION() {
        return ID_INSTITUCION;
    }

    /**
     * @param ID_INSTITUCION the ID_INSTITUCION to set
     */
    public void setID_INSTITUCION(String ID_INSTITUCION) {
        this.ID_INSTITUCION = ID_INSTITUCION;
    }

    /**
     * @return the NOMBRE
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * @param NOMBRE the NOMBRE to set
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * @return the CLASE
     */
    public String getCLASE() {
        return CLASE;
    }

    /**
     * @param CLASE the CLASE to set
     */
    public void setCLASE(String CLASE) {
        this.CLASE = CLASE;
    }

    /**
     * @return the PAIS
     */
    public String getPAIS() {
        return PAIS;
    }

    /**
     * @param PAIS the PAIS to set
     */
    public void setPAIS(String PAIS) {
        this.PAIS = PAIS;
    }
    
}
