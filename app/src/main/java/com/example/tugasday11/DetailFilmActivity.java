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
import com.example.tugasday11.databinding.ActivityDetailFilmBinding;

public class DetailFilmActivity extends AppCompatActivity {

    private ActivityDetailFilmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailFilmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backDetailFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnBeliTiketDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFilmActivity.this, PilihJadwalActivity.class);
                startActivity(intent);
            }
        });


    }
}