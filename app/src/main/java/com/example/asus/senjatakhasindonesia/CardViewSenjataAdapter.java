package com.example.asus.senjatakhasindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewSenjataAdapter extends RecyclerView.Adapter<CardViewSenjataAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Senjata> listSenjata;

    public ArrayList<Senjata> getListSenjata() {
        return listSenjata;
    }

    public void setListSenjata(ArrayList<Senjata> listSenjata) {
        this.listSenjata = listSenjata;
    }

    public CardViewSenjataAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_senjata, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, final int i) {
        Senjata p = getListSenjata().get(i);
        Glide.with(context)
                .load(p.getFoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(p.getNama());
        cardViewViewHolder.tvRemarks.setText(p.getRemarks());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListSenjata().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListSenjata().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(context.getApplicationContext(), MoveToDetail.class);
                s.putExtra("nama", getListSenjata().get(i).getNama());
                s.putExtra("detail", getListSenjata().get(i).getDetil());
                s.putExtra("image", getListSenjata().get(i). getFoto());
                context.startActivity(s);
            }
        });

        cardViewViewHolder.tulisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(context.getApplicationContext(), MoveToDetail.class);
                s.putExtra("nama", getListSenjata().get(i).getNama());
                s.putExtra("detail", getListSenjata().get(i).getDetil());
                s.putExtra("image", getListSenjata().get(i). getFoto());
                context.startActivity(s);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListSenjata().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        RelativeLayout tulisan;


        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
            tulisan = itemView.findViewById(R.id.detaill);

        }
    }
}
