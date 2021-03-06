package com.example.carl.stockit;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carl.stockit.AddProduitActivity;
import com.example.carl.stockit.MyApplication;
import com.example.carl.stockit.R;

public class AddReferenceActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reference);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // lol
        //setSupportActionBar(toolbar);

        final EditText editTextNomReference = (EditText) findViewById(R.id.input_nomReference);
        final EditText editTextCodeBarre = (EditText) findViewById(R.id.codeBarre);
        final EditText editTextCategorie= (EditText) findViewById(R.id.categorie);
        final EditText editURLPhoto= (EditText) findViewById(R.id.URLPhoto);

        InitNav initNav = new InitNav(this);
        initNav.initleftnav();

        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutReference);


        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNomReference.getText().toString().trim().isEmpty()&&
                        editTextCodeBarre.getText().toString().trim().isEmpty()&&
                        editTextCategorie.getText().toString().trim().isEmpty()&&
                        editURLPhoto.getText().toString().trim().isEmpty()){
                    Toast.makeText(AddReferenceActivity.this, R.string.mandatory_message, Toast.LENGTH_LONG).show();
                }
                else {
                    ((MyApplication) getApplication()).getStorageService().addReference(AddReferenceActivity.this,
                            editTextNomReference.getText().toString().trim(),
                            Integer.parseInt( editTextCodeBarre.getText().toString()),
                            editTextCategorie.getText().toString().trim(),
                            editURLPhoto.getText().toString().trim());
                    AddReferenceActivity.this.finish();
                }
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}