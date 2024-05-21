package com.example.tugasday11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugasday11.databinding.ActivityDaftarFilmctivityBinding;
import com.example.tugasday11.databinding.ActivityMainBinding;

public class DaftarFilmctivity extends AppCompatActivity {

    private ActivityDaftarFilmctivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDaftarFilmctivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backDaftarFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.imgDaftarFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarFilmctivity.this, DetailFilmActivity.class);
                startActivity(intent);
            }
        });

        binding.btnBeliTiketDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarFilmctivity.this, PilihJadwalActivity.class);
                startActivity(intent);
            }
        });

    }
}