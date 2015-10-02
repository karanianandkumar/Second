package com.yfjc.christsongs;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class About extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
	        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
	        
	        Typeface robotoBoldCondensedItalic = Typeface.createFromAsset(getAssets(), "fonts/Mallanna.ttf");
	        if(actionBarTitleView != null){
	            actionBarTitleView.setTypeface(robotoBoldCondensedItalic);
	            
	        }
	        
		setContentView(R.layout.aboutus);
		android.support.v7.app.ActionBar actionBar=getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
	}

}
