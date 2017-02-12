package com.merahputihku.exploreindonesia.Models;

/**
 * Created by doy on 2/11/17.
 */

public class Provinsi {
    private String nama;
    private int total;
    private int image;

    public Provinsi(String namaProvinsi, int totalWisata, int imageProvinsi) {
        this.nama = namaProvinsi;
        this.total = totalWisata;
        this.image = imageProvinsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
