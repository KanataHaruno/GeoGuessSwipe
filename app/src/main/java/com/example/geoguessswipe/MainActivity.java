package com.example.geoguessswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create list for the images
        final List<GeoObject> mGeoObjects = new ArrayList<>();

        // Fill the list with image ID and information about if they're in europe or not
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {

            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoObject.PRE_DEFINED_ISEUROPEAN_BOOLEANS[i]));
        }

        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);

        // Set the layout manager and the adapter
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1,
                LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);




        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback
                (0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            // What happens when the image is swiped
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Set the GeoObjectViewHolder as the viewholder used in the parameter
                GeoObjectViewHolder geoViewHolder = (GeoObjectViewHolder) viewHolder;


                if (direction == ItemTouchHelper.LEFT && geoViewHolder.isEuropean ||
                direction == ItemTouchHelper.RIGHT && !geoViewHolder.isEuropean) {
                    Toast.makeText(MainActivity.this, "You're correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You're wrong!", Toast.LENGTH_SHORT).show();
                }


            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);

    }



}
