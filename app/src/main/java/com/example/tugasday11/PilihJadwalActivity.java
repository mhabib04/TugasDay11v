package com.example.tugasday11;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.tugasday11.databinding.ActivityPilihJadwalBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PilihJadwalActivity extends AppCompatActivity {

    private ActivityPilihJadwalBinding binding;

    Ticket ticket = new Ticket();
    String tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPilihJadwalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backPilihJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            long date = System.currentTimeMillis();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
                            tanggal = sdf.format(new Date(date));
                            binding.tvTanggalPilihJadwal.setText(tanggal);
                        }
                    });

                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
                                tanggal = sdf.format(new Date(date));
                                binding.tvTanggalPilihJadwal.setText(tanggal);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        t.start();


        binding.jam1400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket.setJamTayang("14.00");
                Intent intent = new Intent(PilihJadwalActivity.this, PilihKursiActivity.class);
                intent.putExtra(PilihKursiActivity.KEY_DATA, ticket);
                startActivity(intent);
            }
        });

        binding.jam1530.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket.setJamTayang("15.30");
                Intent intent = new Intent(PilihJadwalActivity.this, PilihKursiActivity.class);
                intent.putExtra(PilihKursiActivity.KEY_DATA, ticket);
                startActivity(intent);
            }
        });

        binding.jam1600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket.setJamTayang("16.00");
                Intent intent = new Intent(PilihJadwalActivity.this, PilihKursiActivity.class);
                intent.putExtra(PilihKursiActivity.KEY_DATA, ticket);
                startActivity(intent);
            }
        });

        binding.jam1800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket.setJamTayang("18.00");
                Intent intent = new Intent(PilihJadwalActivity.this, PilihKursiActivity.class);
                intent.putExtra(PilihKursiActivity.KEY_DATA, ticket);
                startActivity(intent);
            }
        });


    }
}