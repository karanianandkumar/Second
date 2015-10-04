package com.yfjc.christsongs;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.StandardExceptionParser;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View; 
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView; 
import android.widget.ArrayAdapter; 
import android.widget.LinearLayout;
import android.widget.ListView; 
import android.widget.TextView; 
import android.widget.Toast; 
import android.widget.AdapterView.OnItemClickListener;


public class EngSongs extends Activity implements OnItemClickListener {
	private EasyTracker easyTracker=null;
	TextView tv1;
	ListView lv,lv2;
	LinearLayout ll;
	
	String songlis[]={};
	int indexes[]={0,7,10,12,17,22,23,27,31,34,42,43,48,76,80,90,95,111,115,117};
	int letter=0,song;
	Typeface mfont;
	Configuration config;
	ArrayAdapter<String> adapter,adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
        
        
        int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
        
        Typeface robotoBoldCondensedItalic = Typeface.createFromAsset(getAssets(), "fonts/Mallanna.ttf");
        if(actionBarTitleView != null){
            actionBarTitleView.setTypeface(robotoBoldCondensedItalic);
            
        }
        
        setContentView(R.layout.eng_activity_main);
        
       
       
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Mallanna.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Mallanna.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Mallanna.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Mallanna.ttf");
        
       
        //Adding Google Analytics...
        easyTracker=EasyTracker.getInstance(EngSongs.this);
        easyTracker.send(MapBuilder.createEvent("TrackEventTest", "page_loaded", "main_page", null).build());
        
        try {
			int a[] = new int[2];
			int num = a[4];
		} catch (ArrayIndexOutOfBoundsException e) {
			easyTracker.send(MapBuilder.createException(
							new StandardExceptionParser(EngSongs.this, null)
									.getDescription(Thread.currentThread().getName(), e), false).build());
		}
		
       
		//Locate the Banner Ad in activity_main.xml
		AdView adView = (AdView) this.findViewById(R.id.adView);

		// Request for Ads
		AdRequest adRequest = new AdRequest.Builder()
 
		// Add a test device to show Test Ads
		
		.addTestDevice("2181F924609987B5E1B7117BAB38E3DA")
				.build();
 
		// Load ads into Banner Ads
		adView.loadAd(adRequest);
 
		// Load ads into Interstitial Ads
		
 
		// Prepare an Interstitial Ad Listener
		
	
	
	
        ll=(LinearLayout)findViewById(R.id.adLayoutView);
        if (isNetworkAvailable(getBaseContext())) {
        	ll.setVisibility(LinearLayout.VISIBLE);
            
        } else {
        	ll.setVisibility(LinearLayout.GONE);
            
        }
        
        

        
       
        
        Locale locale = new Locale("te");
        Locale.setDefault(locale);
        config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        
        mfont=Typeface.createFromAsset(getAssets(), "fonts/Mallanna.ttf");
        
       
        Resources res=getResources();
        
        
        
        String lis[]=res.getStringArray(R.array.Eng_Alphabets);
        final List<String> Alphalist=Arrays.asList(lis);
        songlis=res.getStringArray(R.array.Eng_SongList);
        lv=(ListView)findViewById(R.id.listView1);
        lv2=(ListView)findViewById(R.id.listView2);
        adapter=new ArrayAdapter<String>(EngSongs.this,  R.layout.activity_listview,lis);
       
        lv.setAdapter(adapter);
      
      String str=songlis[0];
      String result[]=str.split(",");
    adapter2= new ArrayAdapter<String>(EngSongs.this,  R.layout.activity_listview,result);
      lv2.setAdapter(adapter2);
        
      LayoutAnimationController controller 
      = AnimationUtils.loadLayoutAnimation(
        this, R.anim.list_layout_controller);
     lv2.setLayoutAnimation(controller);
     
   
        
        lv.setOnItemClickListener(this);
        lv2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                 
            	song=position;
            	Intent i = new Intent(getApplicationContext(), EngLyricDisp.class);
            	i.putExtra("pos",""+(indexes[letter]+song));
            	
            	
            	startActivity(i);
            	
                }
              });
            
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
*/
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub

		letter=position;
    	String str=songlis[position];
    	String res[]=str.split(",");
    	adapter2= new ArrayAdapter<String>(EngSongs.this,  R.layout.activity_listview,res);
        lv2.setAdapter(adapter2);
        LayoutAnimationController controller 
        = AnimationUtils.loadLayoutAnimation(
          this, R.anim.list_layout_controller);
       lv2.setLayoutAnimation(controller);
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

	public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
