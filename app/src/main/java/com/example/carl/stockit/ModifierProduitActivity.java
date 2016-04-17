package com.example.carl.stockit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by carl on 16/04/16.
 */
public class ModifierProduitActivity extends AppCompatActivity implements View.OnClickListener{

    private int pYear;
    private int pMonth;
    private int pDay;
    ImageButton datePicker;
    EditText txtDate;
    static final int DATE_DIALOG_ID = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produit);

        final EditText editTextNomProduit = (EditText) findViewById(R.id.input_nomProduit);
        final EditText editTextQtiteProduit = (EditText) findViewById(R.id.input_quantiteProduit);
        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabAjoutProduit);

        txtDate = (EditText) findViewById(R.id.editText_calendarProduit);
        datePicker = (ImageButton) findViewById(R.id.imageButton_calendarProduit);
        datePicker.setOnClickListener(this);

        final Date date = new Date();



        //final Date finalDateExp = dateExp;
        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNomProduit.getText().toString().trim().isEmpty()&&editTextQtiteProduit.getText().toString().trim().isEmpty()&&txtDate.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ModifierProduitActivity.this, R.string.mandatory_message, Toast.LENGTH_LONG).show();
                } else {
                    ((MyApplication) getApplication()).getStorageService().addProduit(ModifierProduitActivity.this, editTextNomProduit.getText().toString().trim(),Integer.parseInt( editTextQtiteProduit.getText().toString()),pDay,pMonth,pYear);
                    ModifierProduitActivity.this.finish();
                }
            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}
