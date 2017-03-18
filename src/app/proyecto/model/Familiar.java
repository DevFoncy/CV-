package app.proyecto.model;

public class Familiar {
    private int ID_FAM;
    private int ID_POSTULANTE;
    private String TIPO_FAM;
    private String NOMBRE_FAM;
    private int AÑONAC_FAM;
    private String OCUP_FAM;

    /**
     * @return the ID_FAM
     */
    public int getID_FAM() {
        return ID_FAM;
    }

    /**
     * @param ID_FAM the ID_FAM to set
     */
    public void setID_FAM(int ID_FAM) {
        this.ID_FAM = ID_FAM;
    }

    /**
     * @return the TIPO_FAM
     */
    public String getTIPO_FAM() {
        return TIPO_FAM;
    }

    /**
     * @param TIPO_FAM the TIPO_FAM to set
     */
    public void setTIPO_FAM(String TIPO_FAM) {
        this.TIPO_FAM = TIPO_FAM;
    }

    /**
     * @return the NOMBRE_FAM
     */
    public String getNOMBRE_FAM() {
        return NOMBRE_FAM;
    }

    /**
     * @param NOMBRE_FAM the NOMBRE_FAM to set
     */
    public void setNOMBRE_FAM(String NOMBRE_FAM) {
        this.NOMBRE_FAM = NOMBRE_FAM;
    }

    /**
     * @return the AÑO_NAC_FAM
     */
    public int getAÑO_NAC_FAM() {
        return getAÑONAC_FAM();
    }

    /**
     * @param AÑO_NAC_FAM the AÑO_NAC_FAM to set
     */
    public void setAÑO_NAC_FAM(int AÑO_NAC_FAM) {
        this.setAÑONAC_FAM(AÑO_NAC_FAM);
    }

    /**
     * @return the OCUP_FAM
     */
    public String getOCUP_FAM() {
        return OCUP_FAM;
    }

    /**
     * @param OCUP_FAM the OCUP_FAM to set
     */
    public void setOCUP_FAM(String OCUP_FAM) {
        this.OCUP_FAM = OCUP_FAM;
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
     * @return the AÑONAC_FAM
     */
    public int getAÑONAC_FAM() {
        return AÑONAC_FAM;
    }

    /**
     * @param AÑONAC_FAM the AÑONAC_FAM to set
     */
    public void setAÑONAC_FAM(int AÑONAC_FAM) {
        this.AÑONAC_FAM = AÑONAC_FAM;
    }

   

}
