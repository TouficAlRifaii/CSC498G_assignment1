package com.lau.usdlbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText lbp;
    EditText usd;
    Button converter;
    TextView converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbp = (EditText) findViewById(R.id.LBP);
        usd = (EditText) findViewById(R.id.USD);
        converted = findViewById(R.id.convertedAmount);
    }

    public void convert(View v) {
        String lbpAmount = lbp.getText().toString();

        String usdAmount = usd.getText().toString();

        if (lbpAmount.length() == 0 && usdAmount.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter an Amount", Toast.LENGTH_LONG).show();
        } else if (lbpAmount.length() > 0 && usdAmount.length() > 0) {
            Toast.makeText(getApplicationContext(), "Enter only 1 Amount", Toast.LENGTH_LONG).show();
        } else if (lbpAmount.length() > 0 && usdAmount.length() == 0) {
            try {
                double lbpAm = Double.parseDouble(lbpAmount);
                double toUsd = lbpAm / 22000;
                converted.setText(toUsd + "$");
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Enter only numbers", Toast.LENGTH_LONG).show();
            }
        } else {
            try {
                double usdAm = Double.parseDouble(usdAmount);
                double toLbp = usdAm * 22000;
                converted.setText(toLbp + "L.L");
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Enter only numbers", Toast.LENGTH_LONG).show();

            }
        }
    }


}
