package com.is413.tempertureintents;

import temperature.Celsius;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CelsiusActivity extends Activity {

	private Button submitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_celsius);

		submitButton = (Button) findViewById(R.id.cButton);

		submitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();

				try {
					double result = new Celsius(intent.getDoubleExtra(
							"SUBMISSION", -275)).convertToFahrenhiet();
					intent.putExtra("RESULT", result);

					setResult(3, intent);
				} catch (Exception e) {
					setResult(4, intent);
				}
				finish();
			}
		});
	}
}
