package com.example.cmeyering.vainglory101;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;

/**
 * Created by cmeyering on 11/11/16.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds;
    private int numItems;
    private String[] names;

    public ImageAdapter(Context c, List<String> names) {
        mContext = c;
        numItems = names.size();
        mThumbIds = new Integer[numItems];
        this.names = names.toArray(new String[numItems]);
        setItemIds();
    }
    public void setItemIds(){
        for (int i=0; i<numItems; i++){
             mThumbIds[i] = mContext.getResources().
                     getIdentifier(names[i], "drawable", mContext.getPackageName());
        }
    }
    public int getCount(){
        return mThumbIds.length;
    }
    public Object getItem(int position) {
        return Character.toUpperCase(names[position].charAt(0))+names[position].substring(1);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
