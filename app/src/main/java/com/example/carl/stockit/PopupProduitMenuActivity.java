package com.example.carl.stockit;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by carl on 16/04/16.
 */
public class PopupProduitMenuActivity extends Activity implements OnMenuItemClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageButton_settings_produit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(PopupProduitMenuActivity.this, view);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) PopupProduitMenuActivity.this);
                popupMenu.inflate(R.menu.produit_settings_menu);
                popupMenu.show();
            }
        });
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
