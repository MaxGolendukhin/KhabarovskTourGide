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


///**
// * A fragment representing a list of Items.
// * <p/>
// * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
// * interface.
// */
public class MuseumsFragment extends Fragment {
    ArrayList<Sight> sights;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MuseumsFragment() {
    }

//    // TODO: Customize parameter initialization
//    @SuppressWarnings("unused")
//    public static MuseumsFragment newInstance(int columnCount) {
//        MuseumsFragment fragment = new MuseumsFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        //Bundle bundle = getArguments();
        sights = getSights();


        //ArrayList<Sight> sights = (ArrayList<Sight>)bundle.getSerializable("sights");


        //final SightRecyclerViewAdapter sightRecyclerViewAdapter = new SightRecyclerViewAdapter(museumSights);
        final SightAdapter sightAdapter = new SightAdapter(getContext(), sights);
        //RecyclerView recyclerView = view.findViewById(R.id.list);
        ListView listView = view.findViewById(R.id.list_view);
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

//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(DummyItem item);
//    }

    private ArrayList<Sight> getSights() {
        Resources resources = getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.museums);
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
