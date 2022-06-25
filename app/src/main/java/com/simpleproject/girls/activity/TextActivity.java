package com.simpleproject.girls.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;

import com.simpleproject.girls.R;
import com.simpleproject.girls.databinding.ActivityTextBinding;

public class TextActivity extends AppCompatActivity {

    ActivityTextBinding binding;

    Bundle bundle;

    String description;

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();

        description = bundle.getString("description");

        title = bundle.getString("title");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtHealth.setText(Html.fromHtml("<h2>" + title + "</h2>" + "<br>" + "<p>" + description + "</p>"
                    , Html.FROM_HTML_MODE_COMPACT));
        }else  {
            binding.txtHealth.setText(Html.fromHtml("<h2>" + title + "</h2>" + "<br>" + "<p>" + description +"</p>"));
        }


        // binding.txtTitleHealth.setText(title);


    }
}