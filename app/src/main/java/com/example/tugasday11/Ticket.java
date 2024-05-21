package com.example.tugasday11;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Ticket implements Parcelable {
    private List<String> kursiTerpilih;
    private String tanggal;
    private String jamTayang;

    public Ticket() {
        this.kursiTerpilih = new ArrayList<>();
    }

    protected Ticket(Parcel in) {
        kursiTerpilih = in.createStringArrayList();
        tanggal = in.readString();
        jamTayang = in.readString();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    public List<String> getKursiTerpilih() {
        return kursiTerpilih;
    }

    public void tambahKursi(String kursi) {
        kursiTerpilih.add(kursi);
    }

    public void hapusKursi(String kursi) {
        kursiTerpilih.remove(kursi);
    }

    public void hapusKursiTerpilih() {
        getKursiTerpilih().clear();
    }

    public void clearKursiTerpilih() {
        kursiTerpilih.clear();
    }


    public int getBanyakTiket() {
        return kursiTerpilih.size();
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


    public String getJamTayang() {
        return jamTayang;
    }

    public void setJamTayang(String jamTayang) {
        this.jamTayang = jamTayang;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(kursiTerpilih);
        dest.writeString(tanggal);
        dest.writeString(jamTayang);
    }
}
