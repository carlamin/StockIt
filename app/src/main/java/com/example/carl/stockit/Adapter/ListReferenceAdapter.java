package com.example.carl.stockit.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.carl.stockit.Data.LieuStockage;
import com.example.carl.stockit.Data.Reference;
import com.example.carl.stockit.MyApplication;
import com.example.carl.stockit.R;

import java.util.List;

/**
 * Created by Bzah on 26/04/2016.
 */
public class ListReferenceAdapter extends ArrayAdapter<Reference> implements MenuItem.OnMenuItemClickListener {
    private List<Reference> listReference;
    Context context;
    Activity activity;

    public ListReferenceAdapter(Activity activity, Context context, int resource) {
        super(context, resource);
        this.activity = activity;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_reference, null);
            final View buttonSuppr = v.findViewById(R.id.imageButton_deleteReference);
            final TextView childAt = (TextView) v.findViewById(R.id.textView_nomreference);
            buttonSuppr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Reference reference = ((MyApplication) activity.getApplication()).getStorageService().getReferenceByName((String) childAt.getText());
                    if (reference != null) {
                        remove(reference);
                        ((MyApplication) activity.getApplication()).getStorageService().removeReference(reference);

                    }


                }
            });
        }
        final Reference reference = getItem(position);

        if (reference != null) {

            TextView textView_nomL = (TextView) v.findViewById(R.id.textView_nomreference);

            if (textView_nomL != null) {
                textView_nomL.setText(reference.getNomRef());
            }

            LinearLayout linearLayoutL = (LinearLayout) v.findViewById(R.id.linearLayout_reference);


        }

        return v;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
