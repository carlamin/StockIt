package com.example.carl.stockit.Data;

import java.io.Serializable;

/**
 * Created by carl on 30/03/16.
 */
public class LieuStockage implements Serializable {
    private int id;
    private String nomLieu;
    private int capacite;
    private String localisation;
    private String autreInfos;
    private String image;

    public LieuStockage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LieuStockage(int id, String nomLieu, int capacite, String localisation, String autreInfos, String image) {

        this.id = id;
        this.nomLieu = nomLieu;
        this.capacite = capacite;
        this.localisation = localisation;
        this.autreInfos = autreInfos;
        this.image = image;
    }

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
