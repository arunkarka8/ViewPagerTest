package com.example.viewpagertest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterAll extends BaseAdapter {
    private Context mContext;
    private int mCount;
 // references to our images
    public ArrayList<Integer> arl = new ArrayList<Integer>();
    
    private List<ImageView> mImagesGrid;

    public ImageAdapterAll(Context c, List<ImageView> ImagesGrid ) {
        mContext = c;
        mImagesGrid = ImagesGrid;
    }
    public ImageAdapterAll(Context c, int count) {
        mContext = c;
        mCount = count;
    }

    public int getCount() {
        return mImagesGrid.size();
    }
    public void setCount(int count) {
    	mCount = count;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        //TODO:Lacks clarity in the use of position
        imageView = mImagesGrid.get(position);
        //imageView.setImageResource(R.drawable.sample_3);
        return imageView;
    }
    public void changeGridViewSource(List<ImageView> images){
    	mImagesGrid.clear();
    	//mImagesGrid = images;
    	
    	
    }
    
    
    
}