package com.example.carl.stockit.Data;

/**
 * Created by carl on 30/03/16.
 */
public class LieuStockage {
    private String nomLieu;
    private int capacite;
    private String localisation;
    private String autreInfos;

    public LieuStockage(String nomLieu, String autreInfos, String localisation, int capacite) {
        this.nomLieu = nomLieu;
        this.autreInfos = autreInfos;
        this.localisation = localisation;
        this.capacite = capacite;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getAutreInfos() {
        return autreInfos;
    }

    public void setAutreInfos(String autreInfos) {
        this.autreInfos = autreInfos;
    }
}
