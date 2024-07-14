package com.adi.mediapembelajaranmatematika.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.adi.mediapembelajaranmatematika.Activity.WebPageActivity;
import com.adi.mediapembelajaranmatematika.Models.MateriModels;
import com.adi.mediapembelajaranmatematika.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<MateriModels> data;
    public CustomAdapter (List<MateriModels> data){
        this.data = data;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(data.get(position).getIcon());
        holder.textView.setText(this.data.get(position).getTitle());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.textView.getContext(), WebPageActivity.class);
                intent.putExtra("url", data.get(position).getLink());
                holder.textView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView image;

        public ViewHolder(View view) {
            super(view);

            this.image = view.findViewById(R.id.image);
            this.textView = view.findViewById(R.id.text_title);
        }


    }
}