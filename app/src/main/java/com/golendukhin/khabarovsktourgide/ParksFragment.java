package com.golendukhin.khabarovsktourgide;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ParksFragment extends Fragment {
    @BindView(R.id.list_view) ListView listView;

    ArrayList<Sight> sights;

    public ParksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, view);

        sights = Utils.getSights(getActivity(), R.array.parks);
        SightAdapter sightAdapter = new SightAdapter(getContext(), sights);
        listView.setAdapter(sightAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("sight", sights.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}