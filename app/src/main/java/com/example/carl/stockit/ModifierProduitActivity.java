package com.example.carl.stockit;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Produit;
import com.example.carl.stockit.Data.Reference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by carl on 16/04/16.
 */
public class ModifierProduitActivity extends AppCompatActivity implements View.OnClickListener,Serializable, OnItemSelectedListener{

    private int pYear;
    private int pMonth;
    private int pDay;
    ImageButton datePicker;
    EditText txtDate;
    static final int DATE_DIALOG_ID = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_produit);

        final Produit p = (Produit) getIntent().getSerializableExtra("produit");
final int position = (int) getIntent().getSerializableExtra("position");

        final EditText editTextNomProduit = (EditText) findViewById(R.id.input_nomProduitM);
        editTextNomProduit.setText(p.getNom());

        final EditText editTextQtiteProduitM = (EditText) findViewById(R.id.input_quantitePM);
        editTextQtiteProduitM.setText(""+p.getQuantite());
        FloatingActionButton fabAP = (FloatingActionButton) findViewById(R.id.fabModifierProduit);

        txtDate = (EditText) findViewById(R.id.editText_calendarProduitM);
        txtDate.setText(p.getDateExpiration().toString().trim());
        datePicker = (ImageButton) findViewById(R.id.imageButton_calendarProduitM);

        datePicker.setOnClickListener(this);

        final Date date = new Date();



        //final Date finalDateExp = dateExp;

        // SPINNER POUR LIEUX DE STOCKAGE
        final Spinner spinnar = (Spinner) findViewById(R.id.spinner_modifierLieuProduit);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();
        List<LieuStockage> listLieux = ((MyApplication)getApplication()).getStorageService().restoreLieuxStockage(this);
        for(LieuStockage l : listLieux){
            list.add(l.getNomLieu());

        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnar.setAdapter(adapter);
        spinnar.setOnItemSelectedListener(this);


        // SPINEUR POUR REFERENCE
        final Spinner spinnar2 = (Spinner) findViewById(R.id.spinner2_modifierRefProduit);
        ArrayAdapter<String> adapter2;
        List<String> list2;

        list2 = new ArrayList<String>();

        List<Reference> listReference = ((MyApplication)getApplication()).getStorageService().restoreReference(this);
        for(Reference l : listReference){
            list2.add(l.getNomRef());
        }

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnar2.setAdapter(adapter2);
        spinnar2.setOnItemSelectedListener(this);

        fabAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNomProduit.getText().toString().trim().isEmpty()&&editTextQtiteProduitM.getText().toString().trim().isEmpty()&&txtDate.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ModifierProduitActivity.this, R.string.mandatory_message, Toast.LENGTH_LONG).show();
                } else {
                    ((MyApplication) getApplication()).getStorageService().modifierProduit(ModifierProduitActivity.this,position, editTextNomProduit.getText().toString().trim(),Integer.parseInt( editTextQtiteProduitM.getText().toString()),pDay,pMonth,pYear,spinnar.getSelectedItem().toString().trim(),spinnar2.getSelectedItem().toString().trim());
                    ModifierProduitActivity.this.finish();

                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view ==datePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            pYear = c.get(Calendar.YEAR);
            pMonth = c.get(Calendar.MONTH);
            pDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            pYear=year;
                            pMonth=monthOfYear+1;
                            pDay=dayOfMonth;
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, pYear, pMonth, pDay);
            datePickerDialog.show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {


        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
