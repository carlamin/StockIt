package com.example.carl.stockit;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by carl on 26/03/16.
 */
public class AddProduitActivity extends AppCompatActivity implements View.OnClickListener{
    private int pYear;
    private int pMonth;
    private int pDay;
    ImageButton datePicker;
    EditText txtDate;
    static final int DATE_DIALOG_ID = 0;


    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;
                    updateDisplay();
                    displayToast();
                }
            };

    /** Updates the date in the TextView */
    private void updateDisplay() {
        EditText pDisplayDate = (EditText) findViewById(R.id.editText_calendarProduit);

        pDisplayDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(pMonth + 1).append("/")
                        .append(pDay).append("/")
                        .append(pYear).append(" "));
    }

    /** Displays a notification when the date is updated */
    private void displayToast() {
        EditText pDisplayDate = (EditText) findViewById(R.id.editText_calendarProduit);
        Toast.makeText(this, new StringBuilder().append("Date choosen is ").append(pDisplayDate.getText()),  Toast.LENGTH_SHORT).show();

    }
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
                    ((MyApplication) getApplication()).getStorageService().addProduit(AddProduitActivity.this, editTextNomProduit.getText().toString().trim(),Integer.parseInt( editTextQtiteProduit.getText().toString() ));
                    AddProduitActivity.this.finish();
                }

            }
        });
        txtDate = (EditText) findViewById(R.id.editText_calendarProduit);
        datePicker = (ImageButton) findViewById(R.id.imageButton_calendarProduit);
        datePicker.setOnClickListener(this);


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

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, pYear, pMonth, pDay);
            datePickerDialog.show();
        }
    }
}
