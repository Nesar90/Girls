package com.simpleproject.girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleproject.girls.R;
import com.simpleproject.girls.activity.TextActivity;
import com.simpleproject.girls.models.Content;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthVH> {

    List<Content> contentList;
    Context context;
    LayoutInflater inflater;

    public HealthAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;

    }

    @NonNull
    @Override
    public HealthVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.health_row, null);

        return new HealthVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthVH holder, int position) {

        Content content = contentList.get(position);

        holder.titleHealthText.setText(content.getContentTitle());


        holder.healthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, TextActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("description", content.getContentDescription());
                intent.putExtra("title", content.getContentTitle());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }


    class HealthVH extends RecyclerView.ViewHolder {

        CardView healthCard;
        AppCompatTextView titleHealthText;
        AppCompatImageView favoriteImageNot;
        AppCompatImageView favoriteImage;



        public HealthVH(@NonNull View itemView) {
            super(itemView);

            healthCard = itemView.findViewById(R.id.card_health);
            titleHealthText = itemView.findViewById(R.id.txt_title_health);
            favoriteImageNot = itemView.findViewById(R.id.img_favorite_not);
            favoriteImage = itemView.findViewById(R.id.img_favorite);
        }
    }
}
