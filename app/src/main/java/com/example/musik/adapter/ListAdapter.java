package com.example.musik.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musik.R;
import com.example.musik.api.models.Song;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.example.musik.R;
import com.example.musik.api.models.Song;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    public List<Song> items;

    public ListAdapter(Context context, List<Song> items) {
        this.context = context;
        this.items = items;
    }

    public void setLagu(List<Song> item){
        items.addAll(item);
        notifyDataSetChanged();
    }

    public ListAdapter(ArrayList<Song> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song item=items.get(position);
        Picasso.get().load(item.getImage()).into(holder.fotoImage);
        holder.artistnameText.setText("Artist Name: "+item.getArtist_name());
        holder.nameText.setText("Title Song: "+item.getName());
        holder.releaseText.setText("Release Date: "+item.getReleasedate());
    }

    @Override
    public int getItemCount() {
        return (items != null)?items.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, artistnameText, releaseText;
        ImageView fotoImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.text_name);
            artistnameText = itemView.findViewById(R.id.text_artistname);
            fotoImage =  itemView.findViewById(R.id.image_foto);
            releaseText=itemView.findViewById(R.id.text_release);
        }
    }

}

