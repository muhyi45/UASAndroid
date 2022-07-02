package com.muhyidinyahya.uasandroit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FormSucces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_succes);

        String strOutput = getIntent().getStringExtra("OUTPUT");
        TextView total = (TextView) findViewById(R.id.total);
        total.setText(strOutput);

    }
}