package com.example.geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public boolean isEuropean;
    public ImageView checkImage;
    public View view;


    public GeoObjectViewHolder(View itemView) {

        super(itemView);

        // Adresses the image in the app
        checkImage = itemView.findViewById(R.id.geoImageView);

        view = itemView;

    }



}
