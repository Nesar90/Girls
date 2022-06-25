package com.simpleproject.girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.imageview.ShapeableImageView;
import com.simpleproject.girls.R;
import com.simpleproject.girls.activity.PhotoActivity;
import com.simpleproject.girls.models.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LatestAdapter extends PagerAdapter {

    Context context;
    List<Content> contentList;
    LayoutInflater inflater;

    public LatestAdapter(Context context , List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;
    }


    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.image_latest_layout , null);

        ShapeableImageView latestImage = view.findViewById(R.id.img_latest);

        container.addView(view, 0);

        Content content = contentList.get(position);

        Picasso.get().load(content.getContentThumbnailB()).into(latestImage);

        latestImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , PhotoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("picture" , content.getContentThumbnailB());
                context.startActivity(intent);
            }
        });

        return view;

    }
}
