package com.yfjc.christsongs;



import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class TabLayoutActivity extends TabActivity implements OnTabChangeListener {

	private TabHost tabHost;
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
	        
	        
		setContentView(R.layout.tab_layout);
		
		tabHost=getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		//Telugu Songs..
		intent=new Intent(this,MainActivity.class);
		spec=tabHost.newTabSpec("telugu")
				.setIndicator("Telugu")
				.setContent(intent);
		tabHost.addTab(spec);
		
		//Fav Songs..
				intent=new Intent(this,EngSongs.class);
				spec=tabHost.newTabSpec("tel-eng")
						.setIndicator("Tel-Eng")
						.setContent(intent);
				tabHost.addTab(spec);
				
				tabHost.setCurrentTab(0);
				TextView tv = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title); //Unselected Tabs
	            tv.setTextColor(Color.parseColor("#ffffff"));
	            
	            tabHost.getTabWidget().getChildAt(0)
				.setBackgroundColor(Color.rgb(00, 219, 239));

				tabHost.setOnTabChangedListener(this);

				//tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 60;
				//tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.WHITE);
				//tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 60;
				//tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.WHITE);
				//tabHost.getTabWidget().getChildAt(2).getLayoutParams().height = 40;
				//tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.WHITE);

				

		

	}
	
	@Override
	public void onTabChanged(String tabId) {
		if (tabId.equals("telugu")) {
			tabHost.getTabWidget().getChildAt(0)
					.setBackgroundResource(R.drawable.tab_selector);
			TextView tv = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title); //Unselected Tabs
            tv.setTextColor(Color.parseColor("#ffffff"));
			tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.WHITE);
			TextView tv1 = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title); //Unselected Tabs
            tv1.setTextColor(Color.parseColor("#000000"));
			
			//tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.WHITE);
		} else if (tabId.equals("tel-eng")) {
			tabHost.getTabWidget().getChildAt(1)
					.setBackgroundResource(R.drawable.tab_selector);
			
			TextView tv = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title); //Unselected Tabs
            tv.setTextColor(Color.parseColor("#ffffff"));

			tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.WHITE);
			//tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.WHITE);
			
			TextView tv1 = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title); //Unselected Tabs
            tv1.setTextColor(Color.parseColor("#000000"));
		} 
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	if(item.getItemId()==R.id.action_aboutus){
    		Intent i=new Intent(this,About.class);
    		startActivity(i);
    		return true;
    	}
		return super.onOptionsItemSelected(item);
	}

	
	
}
