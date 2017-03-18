
package app.proyecto.model;

/**
 *
 * @author PC-TOSHIBA
 */
public class Referente {
    private String ID_REFERENTE;
    private int ID_POSTULANTE;
    private int ID_EMPRESA;
    private String NOMBRE;
    private String CARGO;
    private int TELEFONO;

    /**
     * @return the ID_REFERENTE
     */
    public String getID_REFERENTE() {
        return ID_REFERENTE;
    }

    /**
     * @param ID_REFERENTE the ID_REFERENTE to set
     */
    public void setID_REFERENTE(String ID_REFERENTE) {
        this.ID_REFERENTE = ID_REFERENTE;
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
     * @return the TELEFONO
     */
    public int getTELEFONO() {
        return TELEFONO;
    }

    /**
     * @param TELEFONO the TELEFONO to set
     */
    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

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
     * @return the ID_EMPRESA
     */
    public int getID_EMPRESA() {
        return ID_EMPRESA;
    }

    /**
     * @param ID_EMPRESA the ID_EMPRESA to set
     */
    public void setID_EMPRESA(int ID_EMPRESA) {
        this.ID_EMPRESA = ID_EMPRESA;
    }
    
}
