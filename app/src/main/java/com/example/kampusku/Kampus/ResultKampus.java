package com.example.kampusku.Kampus;

import com.google.gson.annotations.SerializedName;

public class ResultKampus {
    private int idKampus;
    private String nama_univ;
    private String lokasi;


    public  String getAlamat(){
        return lokasi;
    }

    public void SetAlamat(String lokasi){
        this.lokasi = lokasi;
    }

    public String getKampus() {
        return nama_univ;
    }

    public void setKampus(String nama_univ) {
        this.nama_univ = nama_univ;
    }

    public int getIdKampus() {
        return idKampus;
    }

    public void setIdKampus(int idKampus) {
        this.idKampus = idKampus;
    }
}
