package com.example.tapme;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FinalScore extends Activity {
	int max, winnerPosition;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_page);

		Button restart = (Button) findViewById(R.id.button1);

		@SuppressWarnings("unchecked")
		 ArrayList<String> player = (ArrayList<String>) getIntent()
				.getSerializableExtra("playerName");
		@SuppressWarnings("unchecked")
		ArrayList<Integer> playerTap = (ArrayList<Integer>) getIntent()
				.getSerializableExtra("tapCount");
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.relative);
		TextView tv = new TextView(this);
		tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		for (int i = 0; i < player.size(); i++) {
			tv.append(player.get(i));
			tv.append(" tapped ");
			tv.append(playerTap.get(i).toString());
			tv.append(" times");
			tv.append("\n\n");
		}

		max = Collections.max(playerTap);
		for (int j = 0; j < playerTap.size(); j++) {
			if (playerTap.get(j) == max) {
				winnerPosition = j;
			}
		}
		tv.append(player.get(winnerPosition) + " WON!!!");
		rl.addView(tv);
		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle("!!! Winner Rocks !!!");
		alert.setMessage(player.get(winnerPosition));

		alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.cancel();
			}
		});
		AlertDialog alertDialog = alert.create();
		alertDialog.show();

		restart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(FinalScore.this, InitialActivity.class));
				finish();
			}
		});

	}
}
