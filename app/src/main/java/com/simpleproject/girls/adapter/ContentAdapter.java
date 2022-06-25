package com.simpleproject.girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleproject.girls.R;
import com.simpleproject.girls.activity.PhotoActivity;
import com.simpleproject.girls.models.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.AlbumVH> {

    List<Content> contentList;
    Context context;
    LayoutInflater inflater;

    public ContentAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;

    }

    @NonNull
    @Override
    public AlbumVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content_row , null);

        return new AlbumVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumVH holder, int position) {

        Content content = contentList.get(position);

        Picasso.get().load(content.getContentThumbnailB()).into(holder.contentImage);

        holder.contentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(context, PhotoActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("picture" , content.getContentThumbnailB());
                    intent.putExtra("fileName" , content.getContentTitle());
                    context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }



    class AlbumVH extends RecyclerView.ViewHolder {

        CardView contentCard;
        AppCompatImageView contentImage;


        public AlbumVH(@NonNull View itemView) {
            super(itemView);

            contentCard = itemView.findViewById(R.id.card_content);
            contentImage = itemView.findViewById(R.id.img_content);

        }
    }
}
