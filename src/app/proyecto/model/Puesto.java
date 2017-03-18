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
public class Puesto {
    private String ID_PUESTO;
    private String ID_EMPRESA;
    private String NOMBRE;
    private String AREA;
    private String CARGO;
    private int NUM_PERSONAS;

    /**
     * @return the ID_PUESTO
     */
    public String getID_PUESTO() {
        return ID_PUESTO;
    }

    /**
     * @param ID_PUESTO the ID_PUESTO to set
     */
    public void setID_PUESTO(String ID_PUESTO) {
        this.ID_PUESTO = ID_PUESTO;
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
     * @return the AREA
     */
    public String getAREA() {
        return AREA;
    }

    /**
     * @param AREA the AREA to set
     */
    public void setAREA(String AREA) {
        this.AREA = AREA;
    }

    /**
     * @return the CARGO
     */
    public String getCARGO() {
        return CARGO;
    }

    /**
     * @param CARGO the CARGO to set
     */
    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }

    /**
     * @return the NUM_PERSONAS
     */
    public int getNUM_PERSONAS() {
        return NUM_PERSONAS;
    }

    /**
     * @param NUM_PERSONAS the NUM_PERSONAS to set
     */
    public void setNUM_PERSONAS(int NUM_PERSONAS) {
        this.NUM_PERSONAS = NUM_PERSONAS;
    }

    /**
     * @return the ID_EMPRESA
     */
    public String getID_EMPRESA() {
        return ID_EMPRESA;
    }

    /**
     * @param ID_EMPRESA the ID_EMPRESA to set
     */
    public void setID_EMPRESA(String ID_EMPRESA) {
        this.ID_EMPRESA = ID_EMPRESA;
    }
    
}
