package com.ideasoft.currencytemperatureconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch switchBt;
    private EditText editText;
    private Button convert;
    private TextView result;
    private RadioButton celRB, freRB, bdtRB, usdRB;
    private RadioGroup tempRG, curryRG;
    Double value;
    RelativeLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();

        switchBt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    switchBt.setText("Temperature");
                    tempRG.setVisibility(View.VISIBLE);
                    curryRG.setVisibility(View.GONE);
                    parentLayout.setBackgroundResource(R.drawable.temp);

                } else {
                    switchBt.setText("Currency");
                    tempRG.setVisibility(View.GONE);
                    curryRG.setVisibility(View.VISIBLE);
                    parentLayout.setBackgroundResource(R.drawable.currency);

                }
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editText.getText().toString();
                if (switchBt.isChecked()) {
                    temperature(number);
                } else {
                    currencyConvert(number);
                }
            }
        });


    }

    private void temperature(String number) {
        if (number.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
        } else {
            if (celRB.isChecked()) {
                value = Double.parseDouble(number);
                result.setText("Celsius - " + ((value - 32) * (0.56)));
            } else if (freRB.isChecked()) {
                value = Double.parseDouble(number);
                result.setText("Fahrenheit - " + ((value * (9 / 5)) + 32));
            }
        }
    }

    private void currencyConvert(String number) {

        if (number.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
        } else {
            if (usdRB.isChecked()) {
                value = Double.parseDouble(number);
                result.setText("USD - " + (value * 80));
            } else if (bdtRB.isChecked()) {
                value = Double.parseDouble(number);
                result.setText("BDT - " + (value / 80));
            }
        }
    }

    private void initial() {
        switchBt = findViewById(R.id.switchView);
        editText = findViewById(R.id.editText);
        convert = findViewById(R.id.check);
        result = findViewById(R.id.result);
        celRB = findViewById(R.id.celRadio);
        freRB = findViewById(R.id.friRadio);
        bdtRB = findViewById(R.id.bdtRadio);
        usdRB = findViewById(R.id.usdRadio);
        tempRG = findViewById(R.id.tempRG);
        curryRG = findViewById(R.id.curRB);
        parentLayout = findViewById(R.id.parentLayout);
    }
}