package com.is413.tempertureintents;

import temperature.Fahrenheit;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FahrenheitActivity extends Activity {

	private Button submitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_fahrenheit);
		
		Log.d("activity", "in activity");

		submitButton = (Button) findViewById(R.id.fButton);
		submitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = getIntent();

				try {
					double result = new Fahrenheit(intent.getDoubleExtra(
							"SUBMISSION", -274)).convertToCelsius();

					intent.putExtra("RESULT", result);

					setResult(3, intent);
				} catch (Exception e) {
					e.printStackTrace();
					setResult(4, intent);
				}

				finish();
			}
		});
	}
}
