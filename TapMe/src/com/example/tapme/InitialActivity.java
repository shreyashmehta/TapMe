package com.example.tapme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InitialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initialactivity);
		final EditText playerNum = (EditText) findViewById(R.id.playerNum);
		final Button submit = (Button) findViewById(R.id.submit);

		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(InitialActivity.this, TapMe.class);
				intent.putExtra("MyString", Integer.parseInt(playerNum.getText().toString()));
				startActivity(intent);
				finish();
			}
		});
	}
}
