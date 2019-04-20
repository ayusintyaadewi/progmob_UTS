package com.example.asus.senjatakhasindonesia;

import android.os.Parcel;
import android.os.Parcelable;

public class Senjata implements Parcelable {
    private String nama, remarks, foto, detil;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getRemarks() {

        return remarks;
    }

    public void setRemarks(String remarks) {

        this.remarks = remarks;
    }

    public String getFoto() {

        return foto;
    }

    public void setFoto(String foto) {

        this.foto = foto;
    }

    public String getDetil() {
        return detil;
    }

    public void setDetil(String detil) {
        this.detil = detil;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.remarks);
        dest.writeString(this.foto);
        dest.writeString(this.detil);
    }

    public Senjata() {
    }
    protected Senjata(Parcel in) {
        this.nama = in.readString();
        this.remarks = in.readString();
        this.foto = in.readString();
        this.detil = in.readString();
    }

    public static final Parcelable.Creator<Senjata> CREATOR = new Parcelable.Creator<Senjata>() {
        @Override
        public Senjata createFromParcel(Parcel source) {
            return new Senjata(source);
        }
        @Override
        public Senjata[] newArray(int size) {
            return new Senjata[size];
        }
    };
}
