package com.example.tugasday11;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tugasday11.databinding.ActivityPilihJadwalBinding;
import com.example.tugasday11.databinding.ActivityPilihKursiBinding;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PilihKursiActivity extends AppCompatActivity {

    private ActivityPilihKursiBinding binding;
    Ticket ticket = new Ticket();

    List<String> kursiTerpilih = new ArrayList<>();

    String tanggal;
    public static final String KEY_DATA = "key_data";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPilihKursiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        t.start();

        binding.backPilihKursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ticket.clearKursiTerpilih();
                kursiTerpilih.clear();

                if (binding.kursiA1.isChecked()) kursiTerpilih.add("A1");
                if (binding.kursiA2.isChecked()) kursiTerpilih.add("A2");
                if (binding.kursiA3.isChecked()) kursiTerpilih.add("A3");
                if (binding.kursiA4.isChecked()) kursiTerpilih.add("A4");
                if (binding.kursiA5.isChecked()) kursiTerpilih.add("A5");

                if (binding.kursiB1.isChecked()) kursiTerpilih.add("B1");
                if (binding.kursiB2.isChecked()) kursiTerpilih.add("B2");
                if (binding.kursiB3.isChecked()) kursiTerpilih.add("B3");
                if (binding.kursiB4.isChecked()) kursiTerpilih.add("B4");
                if (binding.kursiB5.isChecked()) kursiTerpilih.add("B5");

                if (binding.kursiC1.isChecked()) kursiTerpilih.add("C1");
                if (binding.kursiC2.isChecked()) kursiTerpilih.add("C2");
                if (binding.kursiC3.isChecked()) kursiTerpilih.add("C3");
                if (binding.kursiC4.isChecked()) kursiTerpilih.add("C4");
                if (binding.kursiC5.isChecked()) kursiTerpilih.add("C5");

                if (binding.kursiD1.isChecked()) kursiTerpilih.add("D1");
                if (binding.kursiD2.isChecked()) kursiTerpilih.add("D2");
                if (binding.kursiD3.isChecked()) kursiTerpilih.add("D3");
                if (binding.kursiD4.isChecked()) kursiTerpilih.add("D4");
                if (binding.kursiD5.isChecked()) kursiTerpilih.add("D5");

                if (kursiTerpilih.isEmpty()) {
                    Toast.makeText(PilihKursiActivity.this, "Silakan pilih kursi terlebih dahulu.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    for (String kursi : kursiTerpilih) {
                        ticket.tambahKursi(kursi);
                    }
                }

                ticket.setTanggal(tanggal);
                String tanggall = ticket.getTanggal();
                binding.tvTanggal.setText(tanggall);

                binding.tvJam.setText("15.30");

                int banyakKursi = ticket.getBanyakTiket();

                List<String> kursiTerpilihList = ticket.getKursiTerpilih();
                String kursiTerpilihString = TextUtils.join(", ", kursiTerpilihList);

                binding.tvBanyakKursi.setText(banyakKursi + " Kursi Terpilih");
                binding.tvDaftarKursi.setText(kursiTerpilihString);

                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

                int hargaTiket = 35000;
                int total = hargaTiket * banyakKursi;

                binding.tvTotalPembayaran.setText(formatRupiah.format((double)total));
            }
        });

    }
}