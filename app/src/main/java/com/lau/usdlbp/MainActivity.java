package com.lau.usdlbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText lbp;
    EditText usd;
    Button converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbp = (EditText) findViewById(R.id.LBP);
        usd = (EditText) findViewById(R.id.USD);
    }

    public void convert(View v) {
        String lbpAmount = lbp.getText().toString();
        String usdAmount = usd.getText().toString();

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lbpAmount.length() == 0 && usdAmount.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter an Amount", Toast.LENGTH_LONG).show();
                } else if (lbpAmount.length() > 0 && usdAmount.length() > 0) {
                    Toast.makeText(getApplicationContext(), "Enter only 1 Amount", Toast.LENGTH_LONG).show();
                } else if (lbpAmount.length() > 0 && usdAmount.length() == 0) {
                    try {
                        double lbpAm = Integer.parseInt(lbpAmount);
                        double toUsd = lbpAm / 22000;
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Enter only numbers", Toast.LENGTH_LONG).show();
                    }
                } else {
                    try {
                        double usdAm = Integer.parseInt(usdAmount);
                        double toLbp = usdAm * 22000;
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Enter only numbers", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


    }
}