package com.simpleproject.girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleproject.girls.R;
import com.simpleproject.girls.activity.ContentActivity;
import com.simpleproject.girls.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {

    List<Category> categoryList;
    Context context;
    LayoutInflater inflater;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_row, null);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category category = categoryList.get(position);
        Log.e("" , "");

       // holder.categoryImage.setImageResource(Integer.parseInt(category.getCategoryImage()));
        Picasso.get().load(category.getCategoryImage()).into(holder.categoryImage);

        holder.categoryTitle.setText(category.getCategoryName());

        holder.categoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*if (category.getCid() == "4") {
                    Intent intentBeauty = new Intent(context, PhotoActivity.class);
                    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //intent.putExtra("artist" , category.getCid());
                    context.startActivity(intentBeauty);
                    Log.e("" , "");
                } else {
                    Intent intent = new Intent(context, ContentActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("cat_Id" , category.getCid());
                    context.startActivity(intent);
                    Log.e("" , "");
                }*/

                Intent intent = new Intent(context, ContentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("cat_Id" , category.getCid());
                intent.putExtra("title" , category.getCategoryName());
                context.startActivity(intent);
                Log.e("" , "");


            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder {

        CardView categoryCard;
        AppCompatTextView categoryTitle;
        CircleImageView categoryImage;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);

            categoryCard = itemView.findViewById(R.id.card_category);
            categoryTitle = itemView.findViewById(R.id.title_category);
            categoryImage = itemView.findViewById(R.id.img_category);

        }
    }
}
