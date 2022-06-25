package com.simpleproject.girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleproject.girls.R;
import com.simpleproject.girls.activity.MusicActivity;
import com.simpleproject.girls.models.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicVH> {

    List<Content> contentList;
    Context context;
    LayoutInflater inflater;
    int counter ;

    public MusicAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;

    }

    @NonNull
    @Override
    public MusicVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.music_row, null);

        return new MusicVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicVH holder, int position) {

        Content content = contentList.get(position);

        counter = Integer.parseInt(content.getCatId());

        Log.e("" , "");

        //Picasso.get().load(content.getContentThumbnailB()).into(holder.contentImage);

        holder.titleMusicText.setText(content.getContentTitle());
        holder.artistMusicText.setText(content.getContentArtist());

        holder.musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MusicActivity.class);

                intent.putExtra("audio" , content);
                intent.putExtra("number" , contentList.size());
                intent.putExtra("count" , counter);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }


    class MusicVH extends RecyclerView.ViewHolder {

        CardView musicCard;
        AppCompatTextView titleMusicText;
        AppCompatTextView artistMusicText;
        AppCompatImageView forwardIcon;
        AppCompatImageView playIcon;
        AppCompatImageView pauseIcon;
        AppCompatImageView backwardIcon;


        public MusicVH(@NonNull View itemView) {
            super(itemView);

            musicCard = itemView.findViewById(R.id.card_music);
            titleMusicText = itemView.findViewById(R.id.txt_title_music);
            artistMusicText = itemView.findViewById(R.id.txt_artist_music);
            forwardIcon = itemView.findViewById(R.id.img_forward);
            playIcon = itemView.findViewById(R.id.img_play);
            pauseIcon = itemView.findViewById(R.id.img_pause);
            backwardIcon = itemView.findViewById(R.id.img_backward);

        }
    }
}
