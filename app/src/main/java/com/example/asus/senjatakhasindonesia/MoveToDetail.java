package com.example.asus.senjatakhasindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MoveToDetail extends AppCompatActivity {

    TextView nama_senjata, deskripsi;
    ImageView gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_to_detail);

        nama_senjata = findViewById(R.id.weapon);
        deskripsi = findViewById(R.id.descryption);
        gambar = findViewById(R.id.weapon_image);

        Intent s = getIntent();

        String nama = s.getStringExtra("nama");
        String detail = s.getStringExtra("detail");
        String image = s.getStringExtra("image");

        nama_senjata.setText(nama);
        deskripsi.setText(detail);
        Glide.with(this)
                .load(image)
                .apply(new RequestOptions())
                .into(gambar);
    }
}
