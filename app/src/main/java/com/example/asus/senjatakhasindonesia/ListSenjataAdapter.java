package com.example.asus.senjatakhasindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSenjataAdapter extends RecyclerView.Adapter<ListSenjataAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Senjata> listSenjata;

    public ListSenjataAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Senjata> getListSenjata() {
        return listSenjata;
    }

    public void setListSenjata(ArrayList<Senjata> listSenjata) {
        this.listSenjata = listSenjata;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_senjata, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tvName.setText(getListSenjata().get(position).getNama());
        categoryViewHolder.tvRemarks.setText(getListSenjata().get(position).getRemarks());
        Glide.with(context)
                .load(getListSenjata().get(position).getFoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(context.getApplicationContext(), MoveToDetail.class);
                s.putExtra("nama", getListSenjata().get(position).getNama());
                s.putExtra("detail", getListSenjata().get(position).getDetil());
                s.putExtra("image", getListSenjata().get(position). getFoto());
                context.startActivity(s);
            }
        });

        categoryViewHolder.tulisan.setOnClickListener(new View.OnClickListener() {
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

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        LinearLayout tulisan;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tulisan = itemView.findViewById(R.id.klik_text);
        }
    }
}
