package com.example.tapme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SplashTapMe extends Activity {
	private final static int SPLASH_TIME_OUT = 3000;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.splash_tap_me);
	
	ImageView iv = (ImageView) findViewById(R.id.splash);
	iv.setScaleType(ScaleType.FIT_XY);
	
	Handler handler = new Handler();
	handler.postDelayed(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			startActivity(new Intent(SplashTapMe.this, InitialActivity.class));
			finish();
		}
	}, SPLASH_TIME_OUT);
}
}
