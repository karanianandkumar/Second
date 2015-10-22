package com.yfjc.christsongs;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
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
				/*
				//Intent myIntent = new Intent(Splash.this, AlarmReceiver.class);

			    PendingIntent pendingIntent = PendingIntent.getBroadcast(
			            Splash.this, 0, myIntent, 0);

			    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

			Calendar firingCal= Calendar.getInstance();
			Calendar currentCal = Calendar.getInstance();

			firingCal.set(Calendar.HOUR, 8); // At the hour you wanna fire
			firingCal.set(Calendar.MINUTE, 3); // Particular minute
			firingCal.set(Calendar.SECOND, 0); // particular second

			long intendedTime = firingCal.getTimeInMillis();
			long currentTime = currentCal.getTimeInMillis();

			if(intendedTime >= currentTime) // you can add buffer time too here to ignore some small differences in milliseconds
			{
			   //set from today
				Log.d("Today","Starttttt");
			   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			            intendedTime , AlarmManager.INTERVAL_DAY,
			            pendingIntent);

			}
			else{
			   //set from next day
			   // you might consider using calendar.add() for adding one day to the current day
			   firingCal.add(Calendar.DAY_OF_MONTH, 1);
			   intendedTime = firingCal.getTimeInMillis();

			   alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
			            intendedTime , AlarmManager.INTERVAL_DAY,
			            pendingIntent);

			}
			
			*/
			}
			
		};
		
 
		// Start the timer
		RunSplash.schedule(ShowSplash, Delay);
	}



}