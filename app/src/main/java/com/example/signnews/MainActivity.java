package com.example.signnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.example.signnews.UI.CategoryCountry;
import com.example.signnews.UI.WorldNewsActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialCardView cvHead, cvGlobal;
    TextView tvToday;
    String hariIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHead = findViewById(R.id.cardHeadLine);
        cvGlobal = findViewById(R.id.cardWorldNews);

        cvHead.setOnClickListener(this);
        cvGlobal.setOnClickListener(this);

        tvToday = findViewById(R.id.tvDate);

        getDate();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cardHeadLine) {
            Intent intent = new Intent(MainActivity.this, CategoryCountry.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardWorldNews) {
            Intent intent = new Intent(MainActivity.this, WorldNewsActivity.class);
            startActivity(intent);
        }
    }

    public void getDate(){
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);
        if (hariIni.equalsIgnoreCase("sunday")) {
            hariIni = "Minggu";
        } else if (hariIni.equalsIgnoreCase("monday")) {
            hariIni = "Senin";
        } else if (hariIni.equalsIgnoreCase("tuesday")) {
            hariIni = "Selasa";
        } else if (hariIni.equalsIgnoreCase("wednesday")) {
            hariIni = "Rabu";
        } else if (hariIni.equalsIgnoreCase("thursday")) {
            hariIni = "Kamis";
        } else if (hariIni.equalsIgnoreCase("friday")) {
            hariIni = "Jumat";
        } else if (hariIni.equalsIgnoreCase("saturday")) {
            hariIni = "Sabtu";
        }
        hariIni = hariIni + ", " + (String) DateFormat.format("dd MMMM yyyy", dateNow);
        tvToday.setText(hariIni);
    }
}