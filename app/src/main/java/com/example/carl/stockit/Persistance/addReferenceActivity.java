package com.example.carl.stockit.Persistance;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carl.stockit.AddProduitActivity;
import com.example.carl.stockit.MyApplication;
import com.example.carl.stockit.R;

public class addReferenceActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reference);

        final EditText editTextNomReference = (EditText) findViewById(R.id.input_nomReference);
        final EditText editTextCodeBarre = (EditText) findViewById(R.id.codeBarre);
        final EditText editTextCategorie= (EditText) findViewById(R.id.categorie);
        final EditText editURLPhoto= (EditText) findViewById(R.id.URLPhoto);

        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutReference);


        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** TO DO **/
            }
        });
    }
}