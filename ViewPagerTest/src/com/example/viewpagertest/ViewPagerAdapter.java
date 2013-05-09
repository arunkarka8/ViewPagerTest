package com.example.viewpagertest;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {

	 Activity activity;
	 int imageArray[];
	 Context mContext;
	 private int mAppCount, i;
	 private int mNoOfPages;
	 private int mGridSize;
	 private List<ImageView> mImagesAll;
	
	 public ViewPagerAdapter(Context cont, Activity act, int AppCount, int GridSize, List<ImageView> images) {
	  activity = act;
	  mContext= cont;
	  mAppCount = AppCount;
	  mGridSize = GridSize;
	  mImagesAll = images;
	  if ((mAppCount % mGridSize) == 0){
		  mNoOfPages = (mAppCount/mGridSize);
	  } else {
		  mNoOfPages = (mAppCount/mGridSize)+1;
	  }
	 }
	 public ViewPagerAdapter(){
		 
	 }
	
	 public int getCount() {
	  return mNoOfPages;
	 }
	
	 public GridView instantiateItem(ViewGroup container, int position) {
		 GridView gridview = new GridView(activity);
		 
		 //TODO: GridView layout Enhancement
		 gridview.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		    LayoutParams.FILL_PARENT));
		 gridview.setColumnWidth(90);
		 gridview.setNumColumns(3);
		 gridview.setVerticalSpacing(10);
		 gridview.setHorizontalSpacing(10);
		 int start=0, end=9;
		/* if(position == 0){
			 start=0;
			 end=mGridSize-1;
		 } else if(position == 1){
			 start= position*mGridSize;
			 end= ((position+1)*mGridSize)-1;
		 } else if(position == (mNoOfPages-1)){
			 start= position*mGridSize;
			 end= mAppCount-1;
		 }*/
		 
		 if(position < mNoOfPages-1){
			 start= position*mGridSize;
			 end= ((position+1)*mGridSize);
		 } else if(position == (mNoOfPages-1)){
			 start= position*mGridSize;
			 end= mAppCount;
		 }
		  
		 /*if (position == 0 ){
			 start =0;
			 end= mGridSize-1;
		 } else if (position != (mNoOfPages-1) ){
			 start =(position*mGridSize);
			 end= (position*mGridSize)+((position+1)*mGridSize)-1;
			
		 } else {
			 start =(position*mGridSize);
			 end= mAppCount-1;
		 }*/
		 
		 
		 ImageAdapterAll CustomAdapter = new ImageAdapterAll(mContext, mImagesAll.subList(start, end));	
		 gridview.setAdapter(CustomAdapter);
		 ((ViewPager) container).addView(gridview, 0);
	  return gridview;
	 }
	
	 @Override
	 public void destroyItem(View arg0, int arg1, Object arg2) {
	  ((ViewPager) arg0).removeView((View) arg2);
	 }
	
	 @Override
	 public boolean isViewFromObject(View arg0, Object arg1) {
	  return arg0 == ((View) arg1);
	 }
	
	 @Override
	 public Parcelable saveState() {
	  return null;
	 }
	 void modifyImagesList(List<ImageView> images){
		 //mImagesAll.clear();
		 mImagesAll = images;
		 
	 }
}

