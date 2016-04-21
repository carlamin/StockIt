package com.example.carl.stockit.Data;

/**
 * Created by carl on 30/03/16.
 */
public class Reference {
    private String nomRef;
    private int codeBarre;
    private String categorie;
    private String URLPhoto;


    public Reference(){}

    public Reference(String nomRef, int codeBarre, String categorie, String URLPhoto) {
        this.nomRef = nomRef;
        this.codeBarre = codeBarre;
        this.categorie = categorie;
        this.URLPhoto = URLPhoto;
    }

    public String getNomRef() {
        return nomRef;
    }

    public void setNomRef(String nomRef) {
        this.nomRef = nomRef;
    }

    public int getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(int codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getURLPhoto() {
        return URLPhoto;
    }

    public void setURLPhoto(String URLPhoto) {
        this.URLPhoto = URLPhoto;
    }
}
