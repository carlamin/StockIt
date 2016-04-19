package com.example.carl.stockit.Persistance;

import android.content.Context;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;

import java.util.List;

/**
 * Created by carl on 26/03/16.
 */
public interface StorageService {
    public void init();
    /**
     * Enregistre la liste des articles passés en paramètre.
     * @param context contexte de l'activité
     * @param articles liste des articles
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<?> store(Context context, List<Produit> articles,List<LieuStockage> listeLieux);

    /**
     * Récupère la liste des articles sauvegardés.
     * @param context contexte de l'activité
     * @return liste des articles sauvegardés par ordre alphabétique
     */
    public List<?> restoreProduits(Context context);

    /**
     * Vide la liste des articles.
     * @param context contexte de l'activité
     * @return liste des articles vide.
     */
    public List<?> clear(Context context);

    /**
     * Enregistre un nouvel article passé en paramètre.
     * @param context contexte de l'activité
     */
    public void addProduit(Context context, String nomP,int qtite,int pDay,int pMonth,int pYear);
    public void modifierProduit(Context context,int position, String nomP,int qtite,int pDay,int pMonth,int pYear);

   public List<LieuStockage> findLieu();
}
