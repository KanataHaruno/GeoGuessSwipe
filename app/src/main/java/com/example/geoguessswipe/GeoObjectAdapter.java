package com.example.geoguessswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder> {

    private Context context;
    public List<GeoObject> listGeoObject;

    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {

        this.context = context;
        this.listGeoObject = listGeoObject;
    }

    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell,
                parent, false);
        return new GeoObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position) {

        // The holder argument of onBindViewHolder is used to reference the views in the viewHolder
        // Get one item from listGeoObject by using the position
        final GeoObject geoObject = listGeoObject.get(position);

        // Assigns image name from GeoObject class to image
        holder.checkImage.setImageResource(geoObject.getmGeoImageName());

        // Get boolean from GeoObject class to use in MainActivity
        holder.isEuropean = geoObject.getmIsEuropean();
    }

    @Override
    public int getItemCount(){
        // Shows how many items are in the list
        return listGeoObject.size();
    }

}
