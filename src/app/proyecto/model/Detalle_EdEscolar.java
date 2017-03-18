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
public class Detalle_EdEscolar {
    

    private int ID_POSTULANTE;
    private String ID_COLEGIO;
    private String TIPO_EDUCACION;
    private int AÑO_INICIO;
    private int AÑO_TERMINO;
    private String ORDEN_MERITO;

    /**
     * @return the ID_POSTULANTE
     */
    public int getID_POSTULANTE() {
        return ID_POSTULANTE;
    }

    /**
     * @param ID_POSTULANTE the ID_POSTULANTE to set
     */
    public void setID_POSTULANTE(int ID_POSTULANTE) {
        this.ID_POSTULANTE = ID_POSTULANTE;
    }

    /**
     * @return the ID_COLEGIO
     */
    public String getID_COLEGIO() {
        return ID_COLEGIO;
    }

    /**
     * @param ID_COLEGIO the ID_COLEGIO to set
     */
    public void setID_COLEGIO(String ID_COLEGIO) {
        this.ID_COLEGIO = ID_COLEGIO;
    }

    /**
     * @return the TIPO_EDUCACION
     */
    public String getTIPO_EDUCACION() {
        return TIPO_EDUCACION;
    }

    /**
     * @param TIPO_EDUCACION the TIPO_EDUCACION to set
     */
    public void setTIPO_EDUCACION(String TIPO_EDUCACION) {
        this.TIPO_EDUCACION = TIPO_EDUCACION;
    }

    /**
     * @return the AÑO_INICIO
     */
    public int getAÑO_INICIO() {
        return AÑO_INICIO;
    }

    /**
     * @param AÑO_INICIO the AÑO_INICIO to set
     */
    public void setAÑO_INICIO(int AÑO_INICIO) {
        this.AÑO_INICIO = AÑO_INICIO;
    }

    /**
     * @return the AÑO_TERMINO
     */
    public int getAÑO_TERMINO() {
        return AÑO_TERMINO;
    }

    /**
     * @param AÑO_TERMINO the AÑO_TERMINO to set
     */
    public void setAÑO_TERMINO(int AÑO_TERMINO) {
        this.AÑO_TERMINO = AÑO_TERMINO;
    }

    /**
     * @return the ORDEN_MERITO
     */
    public String getORDEN_MERITO() {
        return ORDEN_MERITO;
    }

    /**
     * @param ORDEN_MERITO the ORDEN_MERITO to set
     */
    public void setORDEN_MERITO(String ORDEN_MERITO) {
        this.ORDEN_MERITO = ORDEN_MERITO;
    }

}
