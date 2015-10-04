package com.yfjc.christsongs;

import java.util.Locale;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.StandardExceptionParser;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import android.support.v7.app.ActionBarActivity;

public class EngLyricDisp extends ActionBarActivity {

	private EasyTracker easyTracker=null;
	TextView tv;
	String s[]={};
	
	Configuration config;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		
	    		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
		int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
	        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
	        
	        Typeface robotoBoldCondensedItalic = Typeface.createFromAsset(getAssets(), "fonts/Mallanna.ttf");
	        if(actionBarTitleView != null){
	            actionBarTitleView.setTypeface(robotoBoldCondensedItalic);
	            
	        }
	        
	       
	        setContentView(R.layout.eng_lyric_display);
	        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
			actionBar.setHomeButtonEnabled(true);  
		
		 
		int size=(int) getResources().getDimension(R.dimen.font_size);
		
		//Log.d("Size is:",""+size);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		//Adding Google Analytics...
        easyTracker=EasyTracker.getInstance(EngLyricDisp.this);
        easyTracker.send(MapBuilder.createEvent("TrackEventTest", "page_loaded", "main_page", null).build());
        
        try {
			int a[] = new int[2];
			int num = a[4];
		} catch (ArrayIndexOutOfBoundsException e) {
			easyTracker.send(MapBuilder.createException(
							new StandardExceptionParser(EngLyricDisp.this, null)
									.getDescription(Thread.currentThread().getName(), e), false).build());
		}
		
 
		 Intent intent = getIntent();
		    
		    String fName = intent.getStringExtra("pos");
		    
		    int result=Integer.parseInt(fName);
		 Locale locale = new Locale("te");
	        Locale.setDefault(locale);
	        config = new Configuration();
	        config.locale = locale;
	        getBaseContext().getResources().updateConfiguration(config,
	                getBaseContext().getResources().getDisplayMetrics());
		
	        
		tv=(TextView)findViewById(R.id.textView1);
		Resources res=getResources();
		s=res.getStringArray( R.array.Eng_lyrics);
		tv.setText(s[result]);
		
		Typeface mfont=Typeface.createFromAsset(getAssets(), "fonts/English.ttf");
		tv.setTypeface(mfont,Typeface.BOLD);
		
		
	}



@Override
public void onStart() {
	super.onStart();
	EasyTracker.getInstance(this).activityStart(this);
}

@Override
public void onStop() {
	super.onStop();
	EasyTracker.getInstance(this).activityStop(this);
}

public void onBackPressed() {

    super.onBackPressed();

    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);

}

}
