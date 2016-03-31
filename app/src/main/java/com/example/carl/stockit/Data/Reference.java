package com.example.carl.stockit.Data;

/**
 * Created by carl on 30/03/16.
 */
public class Reference {
    private String nomRef;
    private String codeBarre;
    private String categorie;
    private String URLPhoto;

    public Reference(String nomRef, String codeBarre, String categorie, String URLPhoto) {
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

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
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
