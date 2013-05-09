package com.example.viewpagertest;

/*TODO: The MainActivity should fetch the image files and store them in a DS and supply 
 * them to the PagerAdapter
 * TODO: Delete GridView layout from android
 * 
 */

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private int mAppCount = 12;
	//TODO: The mAppCount value is fetched from the device file
	private int mGridSize = 9;
	//TODO: The mGridSize value is decided based on the device screen size
	
	List<ImageView> mImages;
	ViewPagerAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// The DS "images" is the Image Source
		mImages = new ArrayList<ImageView>();
		
		for (int i = 0; i < mAppCount; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageArra[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImages.add(imageView);
        }
		
		 mAdapter = new ViewPagerAdapter(getApplicationContext(), this, mAppCount, mGridSize, mImages);
		  ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
		  myPager.setAdapter(mAdapter);
		  myPager.setCurrentItem(0);
		 }
	//TODO: Delete the image array when no longer needed
		 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())   
        {  
            case R.id.fifteen:
            	Toast.makeText(this, "You Changed the AppCount to 15 !", Toast.LENGTH_LONG).show();
            	mAppCount = 15;
            	modifyTheMenu(mAppCount);
            break;  
            case R.id.twentyfive:     
            	Toast.makeText(this, "You Changed the AppCount to 25 !", Toast.LENGTH_LONG).show(); 
            	mAppCount = 25;
            	modifyTheMenu(mAppCount);
            break;  
        }  
		return super.onOptionsItemSelected(item);
	}

	private void modifyTheMenu(int mAppCount2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mAppCount; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageArra[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImages.add(imageView);
        }
		mAdapter.modifyImagesList(mImages);
		mAdapter.notifyDataSetChanged();
		
	}
	
	private int imageArra[] = { R.drawable.sample_1, R.drawable.sample_2,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_3, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3,
			   R.drawable.sample_1, R.drawable.sample_3};

}
