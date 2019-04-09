package com.example.geoguessswipe;

public class GeoObject {

    public int mGeoImageName;
    public boolean mIsEuropean;

    public GeoObject(int mGeoImageName, boolean mIsEuropean) {
        this.mGeoImageName = mGeoImageName;
        this.mIsEuropean = mIsEuropean;
    }


    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getmIsEuropean(){
        return  mIsEuropean;
    }

    private void setmIsEuropean(){
        this.mIsEuropean = mIsEuropean;
    }

    // Image names
    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    // Booleans to check if images are european
    public static final boolean[] PRE_DEFINED_ISEUROPEAN_BOOLEANS = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false

    };
}