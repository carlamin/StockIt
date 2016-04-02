package com.example.carl.stockit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by carl on 26/03/16.
 */
public class AddProduitActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produit);

        final EditText editTextNomProduit = (EditText) findViewById(R.id.input_nomProduit);
        final EditText editTextQtiteProduit = (EditText) findViewById(R.id.input_quantiteProduit);
        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutProduit);



        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNomProduit.getText().toString().trim().isEmpty()&&editTextQtiteProduit.getText().toString().trim().isEmpty()) {
                    Toast.makeText(AddProduitActivity.this, R.string.mandatory_message, Toast.LENGTH_LONG).show();
                } else {
                    ((MyApplication) getApplication()).getStorageService().add(AddProduitActivity.this, editTextNomProduit.getText().toString().trim(),Integer.parseInt( editTextQtiteProduit.getText().toString() ));
                    AddProduitActivity.this.finish();
                }

            }
        });
    }
}
