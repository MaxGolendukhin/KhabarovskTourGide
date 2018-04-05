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

public class TheaterFragment extends Fragment {
    @BindView(R.id.list_view) ListView listView;

    ArrayList<Sight> sights;

    public TheaterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, view);

        sights = getSights();
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

    /**
     * @return theaters arrayList to populate list
     */
    private ArrayList<Sight> getSights() {
        Resources resources = getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.theaters);
        int length = typedArray.length();

        String[][] optionsResources = new String[length][];
        for (int i = 0; i < length; ++i) {
            int id = typedArray.getResourceId(i, 0);
            optionsResources[i] = resources.getStringArray(id);
        }
        typedArray.recycle();

        ArrayList<Sight> sights = new ArrayList<>();
        for (int j = 0; j < optionsResources[0].length; j++) {
            sights.add(new Sight(optionsResources[0][j],
                    optionsResources[1][j],
                    optionsResources[2][j],
                    optionsResources[3][j],
                    optionsResources[4][j],
                    resources.getIdentifier(optionsResources[5][j], "drawable", getActivity().getPackageName())));
        }
        return sights;
    }
}