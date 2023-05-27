package com.example.foundmynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ImageViewHolder>{
    private Context mContext;
    private List<Upload> mUploads;

    public imageAdapter(Context context, List<Upload> uploads){
            mContext = context;
            mUploads = uploads;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.lostreports, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewNumber.setText(uploadCurrent.getmNumber());
        Picasso.get()
                .load(uploadCurrent.getmImageurl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNumber;
        public ImageView imageView;
        public TextView textViewDescription;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.number);
            imageView = itemView.findViewById(R.id.imageView);
            textViewDescription = itemView.findViewById(R.id.Description);
        }
    }
}
