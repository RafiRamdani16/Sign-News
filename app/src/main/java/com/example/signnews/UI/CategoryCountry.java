package com.example.signnews.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.signnews.R;
import com.google.android.material.card.MaterialCardView;

public class CategoryCountry extends AppCompatActivity implements View.OnClickListener{
    MaterialCardView cIndonesia, cArgentina, cChina, cGermany, cJapan, cUnitedState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_country);

        cIndonesia = findViewById(R.id.cardIndonesia);
        cArgentina = findViewById(R.id.cardArgentina);
        cChina= findViewById(R.id.cardChina);
        cGermany= findViewById(R.id.cardGermany);
        cJapan = findViewById(R.id.cardJapan);
        cUnitedState = findViewById(R.id.cardUnitedStates);

        cIndonesia.setOnClickListener(this);
        cArgentina.setOnClickListener(this);
        cUnitedState.setOnClickListener(this);
        cJapan.setOnClickListener(this);
        cChina.setOnClickListener(this);
        cGermany.setOnClickListener(this);
        setupToolbar();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CategoryCountry.this, HeadlineActivity.class);
        if (view.getId() == R.id.cardIndonesia) {
            intent.putExtra("country","id");
        } else if (view.getId() == R.id.cardArgentina) {
            intent.putExtra("country","ar");
        } else if (view.getId() == R.id.cardChina) {
            intent.putExtra("country","cn");
        } else if (view.getId() == R.id.cardGermany) {
            intent.putExtra("country","de");
        } else if (view.getId() == R.id.cardJapan) {
            intent.putExtra("country","jp");
        } else if (view.getId() == R.id.cardUnitedStates) {
            intent.putExtra("country","us");
        }
        startActivity(intent);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbCountry);
        toolbar.setTitle("Choose Country");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
