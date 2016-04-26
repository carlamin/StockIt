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
public class AddLieuxStockageActivity extends AppCompatActivity implements View.OnClickListener{




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lieux_stockage);

        final EditText editTextNomLieuxStockage = (EditText) findViewById(R.id.editText_nomLieuStockage);
        final EditText editTextCapaciteStock = (EditText) findViewById(R.id.editText_CapaciteStock);
        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutLieuxStockage);
        final EditText editTextLocalisation = (EditText) findViewById(R.id.editText_Localisation);

        InitNav initNav = new InitNav(this);
        initNav.initleftnav();

        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNomLieuxStockage.getText().toString().trim().isEmpty()&&editTextCapaciteStock.getText().toString().trim().isEmpty()) {
                    Toast.makeText(AddLieuxStockageActivity.this, R.string.mandatory_message, Toast.LENGTH_LONG).show();
                } else {
                    ((MyApplication) getApplication()).getStorageService().addLieuxStockage(AddLieuxStockageActivity.this, editTextNomLieuxStockage.getText().toString().trim(),Integer.parseInt( editTextCapaciteStock.getText().toString()),editTextLocalisation.getText().toString().trim());
                    AddLieuxStockageActivity.this.finish();
                }

            }
        });


    }


    @Override
    public void onClick(View view) {

    }
}

