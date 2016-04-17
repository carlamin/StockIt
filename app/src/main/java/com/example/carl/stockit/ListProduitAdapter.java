package com.example.carl.stockit;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.carl.stockit.Data.Produit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by carl on 02/04/16.
 */
public class ListProduitAdapter extends ArrayAdapter<Produit> implements MenuItem.OnMenuItemClickListener{

    public ListProduitAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListProduitAdapter(Context context, int resource, List<Produit> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_produits, null);
        }

        final Produit p = getItem(position);

        if (p != null) {
            TextView textView_nomP = (TextView) v.findViewById(R.id.textView_nomProduit);
            final EditText editText_qtiteP = (EditText) v.findViewById(R.id.editText_stockProduit);


            if (textView_nomP != null) {
                textView_nomP.setText(p.getNom());
            }

            if (editText_qtiteP != null) {

                editText_qtiteP.setText(String.valueOf(p.getQuantite()));
            }

            Button button_ConsommerP = (Button) v.findViewById(R.id.button_ConsommerProduit);
            Button button_AjouterP = (Button) v.findViewById(R.id.button_AjouterProduit);

           editText_qtiteP.addTextChangedListener(new TextWatcher() {
                                                       @Override
                                                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                       }

                                                       @Override
                                                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                       }

                                                       @Override
                                                       public void afterTextChanged(Editable editable) {
                                                           if (!editText_qtiteP.getText().toString().trim().isEmpty()) {
                                                               int q = Integer.parseInt(editText_qtiteP.getText().toString());
                                                               p.setQuantite(q);


                                                           }

                                                       }});

                    button_AjouterP.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            p.ajouter(1);
                            notifyDataSetChanged();

                        }
                    });
            button_ConsommerP.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    p.consommer(1);
                    notifyDataSetChanged();

                }
            });
            final ImageButton button_settings_produit = (ImageButton) v.findViewById(R.id.imageButton_settings_produit);
            //button_settings_produit.setOnClickListener();

            TextView dateExp = (TextView) v.findViewById(R.id.textView_DateExp);
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            if(dateExp != null){
                dateExp.setText(df.format(p.getDateExpiration()));
            }

            LinearLayout linearLayoutP = (LinearLayout) v.findViewById(R.id.linearLayout_produit);
            final LinearLayout linearLayoutPPF = (LinearLayout) v.findViewById(R.id.linearLayout_produitPlusInfo);

            textView_nomP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(linearLayoutPPF.getVisibility() == View.VISIBLE){
                    linearLayoutPPF.setVisibility(View.GONE);
                }else{
                    linearLayoutPPF.setVisibility(View.VISIBLE);}
                }
            });

            v.findViewById(R.id.imageButton_settings_produit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     PopupMenu popupMenu = new PopupMenu(getContext(), view);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
                                case R.id.produit_modifier :
                                    Intent addIntent = new Intent(getContext(), ModifierProduitActivity.class);
                                    getContext().startActivity(addIntent);
                                    break;
                                case R.id.produit_delete:
                                    remove(p);
                                    break;

                            }
                            return true;
                        }
                    });
                    popupMenu.inflate(R.menu.produit_settings_menu);
                    popupMenu.show();
                }
            });
        }




    return v;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}



