package com.example.carl.stockit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.carl.stockit.Data.Produit;

import java.util.List;

/**
 * Created by carl on 08/04/16.
 */
public class ProduitSettingsButtonListenner implements View.OnClickListener{
   //private Produit p;
    private Context context;
    int position;
    private List<Produit> produits;
    public ProduitSettingsButtonListenner(Context context, List<Produit> p,int i) {
        this.produits = p;
        this.context=context;
        this.position =i;
    }



    @Override
    public void onClick(View view) {
        ImageButton button_settings_produit =(ImageButton) view.findViewById(R.id.imageButton_settings_produit);
        PopupMenu popupMenu = new PopupMenu(context, button_settings_produit){
            public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item){
                int id = item.getItemId();
                switch (id){
                    case R.id.produit_renommer:
                        return true;

                    case R.id.produit_modifier:
                        Intent addIntent = new Intent(context, AddProduitActivity.class);
                        context.startActivity(addIntent);
                        return true;


                    case R.id.produit_delete:
                        produits.remove(position);
                        Toast.makeText(context,"deleted",Toast.LENGTH_SHORT);
                        System.out.println("DELETE");
                        return true;

                    default:
                        return true;
                }}

        };
        popupMenu.inflate(R.menu.produit_settings_menu);
        popupMenu.show();
    }
}
