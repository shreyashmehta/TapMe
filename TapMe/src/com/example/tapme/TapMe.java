package com.example.tapme;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TapMe extends Activity {

	int taps = 0, iterate, tapCount, j = 1;
	String playerName;
	ArrayList<String> player = new ArrayList<String>();
	ArrayList<Integer> playerTap = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_me);
        
        final Button start = (Button) findViewById(R.id.start);
        final TextView time = (TextView) findViewById(R.id.time);
        final TextView score = (TextView) findViewById(R.id.score);
        final Button tap = (Button) findViewById(R.id.tap);
        tap.setEnabled(false);
        
        iterate = getIntent().getExtras().getInt("MyString") - 1;
        
        start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				taps = 0;
				start.setEnabled(false);
				tap.setEnabled(true);
				new CountDownTimer(10000, 100) {
					
					@Override
					public void onTick(long arg0) {
						// TODO Auto-generated method stub
						time.setText("Time remaining: " + arg0/1000);
					}
					
					@Override
					public void onFinish() {
						// TODO Auto-generated method stub
						if((iterate-1)>=0) {
							time.setText("Time Up!");
							start.setEnabled(true);
							tap.setEnabled(false);
							playerName = "Player "+j;
							tapCount = taps;
							player.add(playerName);
							playerTap.add(tapCount);
							iterate--;
							j++;
						}
						else {
							playerName = "Player "+j;
							tapCount = taps;
							player.add(playerName);
							playerTap.add(tapCount);
							Intent intent = new Intent(TapMe.this, FinalScore.class);
							intent.putExtra("playerName", player);
							intent.putExtra("tapCount", playerTap);
							//intent.putCharSequenceArrayListExtra ("player", playerName);
							//intent.putIntegerArrayListExtra ("playerTap", tapCount);
							startActivity(intent);
							finish();
						}
						
					}
				}.start();
			}
		});
        
        tap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				taps++;
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tap_me, menu);
        return true;
    }
    
}
