package com.example.asus.senjatakhasindonesia;

import android.os.Parcel;
import android.os.Parcelable;

public class Senjata implements Parcelable {
    private String nama, remarks, foto;

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

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.remarks);
        dest.writeString(this.foto);
    }

    public Senjata() {
    }
    protected Senjata(Parcel in) {
        this.nama = in.readString();
        this.remarks = in.readString();
        this.foto = in.readString();
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
