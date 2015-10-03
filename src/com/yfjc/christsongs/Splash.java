package com.yfjc.christsongs;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;



import android.content.Context;
import android.graphics.Typeface;

public class Splash extends Activity {
	long Delay = 6000;
	 ImageView iv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove the Title Bar
		
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Get the view from splash_screen.xml
		setContentView(R.layout.splashscreen);
		
		
		
		iv=(ImageView)findViewById(R.id.LogoImage);
		Animation anim=AnimationUtils.loadAnimation(this, R.anim.animation);
		iv.startAnimation(anim);
 
		// Create a Timer
		Timer RunSplash = new Timer();
 
		// Task to do when the timer ends
		TimerTask ShowSplash = new TimerTask() {
			@Override
			public void run() {
				// Close SplashScreenActivity.class
				finish();
 
				// Start MainActivity.class
				Intent myIntent = new Intent(Splash.this,TabLayoutActivity.class);
				startActivity(myIntent);
			}
		};
 
		// Start the timer
		RunSplash.schedule(ShowSplash, Delay);
	}



}