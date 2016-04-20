package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.AddReferenceActivity;
import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;

import java.util.List;

/**
 * Created by carl on 26/03/16.
 */
public interface StorageService {
    /**
     * Enregistre la liste des articles passés en paramètre.
     * @param context contexte de l'activité
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<Produit> storeProduit(Context context, List<Produit> produits);
    public List<LieuStockage> storeLieuStockage(Context context, List<LieuStockage> articles);

    /**
     * Récupère la liste des articles sauvegardés.
     * @param context contexte de l'activité
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<Produit> restoreProduits(Context context);
    public List<LieuStockage> restoreLieuxStockage(Context context);


    /**
     * Vide la liste des articles.
     * @param context contexte de l'activité
     * @return liste des articles vide.
     */
    public List<Produit> clearProduit(Context context);
    public List<LieuStockage> clearLieuStockage(Context context);


    /**
     * Enregistre un nouvel article passé en paramètre.
     * @param context contexte de l'activité
     */
    public void addProduit(Context context, String nomP,int qtite,int pDay,int pMonth,int pYear);
    public void modifierProduit(Context context,int position, String nomP,int qtite,int pDay,int pMonth,int pYear);

    void addReference(AddReferenceActivity addReferenceActivity, String trim, int i, String trim1, String trim2);
}
