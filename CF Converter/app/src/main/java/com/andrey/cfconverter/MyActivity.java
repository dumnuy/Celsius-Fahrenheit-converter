package com.andrey.cfconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MyActivity extends Activity {

    private EditText etValueToConvert;
    private TextView tvResult;
    private RadioButton rbCels, rbFahr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        etValueToConvert = (EditText) findViewById(R.id.etValueToConvert);
        tvResult = (TextView) findViewById(R.id.tvResult);
        rbCels = (RadioButton) findViewById(R.id.rbCelsius);
        rbFahr = (RadioButton) findViewById(R.id.rbFahr);

    }

    public void onConvert(View view) {
        String editTextValue = etValueToConvert.getText().toString();
        if (TextUtils.isEmpty(editTextValue)) {
            etValueToConvert.setError("Enter value!");
            return;
        }
        double valueToConvert = Double.parseDouble(editTextValue);
        double result = 0;
        if (rbCels.isChecked()) {
            result = (valueToConvert * 1.8) + 32;
        } else if (rbFahr.isChecked()) {
            result = (valueToConvert - 32) / 1.8;
        }
        tvResult.setText(String.valueOf(result));

    }
}



