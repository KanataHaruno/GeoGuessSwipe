package com.example.geoguessswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<GeoObject> mGeoObjects;
    GeoObjectAdapter mAdapter;
    RecyclerView mGeoRecyclerView;
    TextView mEndText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create list for the images
        mGeoObjects = new ArrayList<>();

        // Fill the list with image ID and information about if they're in europe or not
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoObject.PRE_DEFINED_ISEUROPEAN_BOOLEANS[i]));
        }

        mGeoRecyclerView = findViewById(R.id.recyclerView);

        // Get textview for text at the end
        mEndText = findViewById(R.id.endTextView);

        // Set the layout manager and the adapter
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1,
                LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);


        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback
                (0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder viewHolderEnd) {
                return false;
            }

            @Override
            // What happens when the image is swiped
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                int position = (viewHolder.getAdapterPosition());
                feedback(position, direction);
                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);

                if (mGeoObjects.size() == 0) {

                    mEndText.setText("End of the images! ");
                }

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }

    private void feedback(int position, int direction) {
        GeoObject swipedObject = mGeoObjects.get(position);

        if (direction == ItemTouchHelper.LEFT && swipedObject.getmIsEuropean() ||
                direction == ItemTouchHelper.RIGHT && !swipedObject.getmIsEuropean()) {
            Toast.makeText(MainActivity.this, "You're correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You're wrong!", Toast.LENGTH_SHORT).show();
        }

    }


}
