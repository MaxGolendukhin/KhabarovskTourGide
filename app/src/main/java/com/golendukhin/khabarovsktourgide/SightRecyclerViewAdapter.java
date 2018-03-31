package com.golendukhin.khabarovsktourgide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SightRecyclerViewAdapter extends RecyclerView.Adapter<SightRecyclerViewAdapter.ViewHolder> {
    private final List<Sight> sights;
    //private final OnListFragmentInteractionListener listener;

    public SightRecyclerViewAdapter(List<Sight> sights) {
        this.sights = sights;
        //this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(sights.get(position).getName());

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return sights.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public View view;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            //this.view = view;
            textView = view.findViewById(R.id.item_text_view);

        }
    }
}
