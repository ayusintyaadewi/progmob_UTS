package com.example.asus.senjatakhasindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridSenjataAdapter extends RecyclerView.Adapter<GridSenjataAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<Senjata> listSenjata;

    public GridSenjataAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Senjata> getListSenjata() {
        return listSenjata;
    }

    public void setListSenjata(ArrayList<Senjata> listSenjata) {
        this.listSenjata = listSenjata;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_senjata, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Glide.with(context)
                .load(getListSenjata().get(position).getFoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(context.getApplicationContext(), MoveToDetail.class);
                s.putExtra("nama", getListSenjata().get(position).getNama());
                s.putExtra("detail", getListSenjata().get(position).getDetil());
                s.putExtra("image", getListSenjata().get(position). getFoto());
                context.startActivity(s);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListSenjata().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
