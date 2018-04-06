package com.golendukhin.khabarovsktourgide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SightAdapter extends ArrayAdapter<Sight> {
    @BindView(R.id.item_image_view) ImageView imageView;
    @BindView(R.id.item_text_view) TextView textView;

    private ArrayList<Sight> sights;

    SightAdapter(Context context, ArrayList<Sight> sights) {
        super(context, 0, sights);
        this.sights = sights;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item, parent, false);
        }
        ButterKnife.bind(this, listItemView);

        imageView.setImageResource(sights.get(position).getImageResourceId());
        textView.setText(sights.get(position).getName());

        return listItemView;
    }
}