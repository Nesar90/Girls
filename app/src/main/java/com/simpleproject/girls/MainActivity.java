package com.simpleproject.girls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.simpleproject.girls.adapter.CategoryAdapter;
import com.simpleproject.girls.adapter.ContentAdapter;
import com.simpleproject.girls.adapter.LatestAdapter;
import com.simpleproject.girls.databinding.ActivityMainBinding;
import com.simpleproject.girls.models.Category;
import com.simpleproject.girls.models.IResponseListener;
import com.simpleproject.girls.models.ObjectCategory;
import com.simpleproject.girls.models.ObjectContent;
import com.simpleproject.girls.webservice.ApiClient;
import com.simpleproject.girls.webservice.IService;
import com.simpleproject.girls.webservice.WebserviceCaller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    WebserviceCaller webserviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        webserviceCaller = new WebserviceCaller();

        webserviceCaller.getLatestContentList(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                ObjectContent objectContent = (ObjectContent) responseMessage;

                LatestAdapter adapter = new LatestAdapter(getApplicationContext(),
                        objectContent.getContent());
                binding.pagerMain.setAdapter(adapter);
                binding.springDotsIndicator.setViewPager(binding.pagerMain);
                //binding.springDotsIndicator.set;
                Log.e("" , "");

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        webserviceCaller.getCategoryList(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                ObjectCategory objectCategory = (ObjectCategory) responseMessage;

                CategoryAdapter categoryAdapter = new CategoryAdapter(objectCategory.getCategory(), getApplicationContext());
                binding.recyclerMain.setAdapter(categoryAdapter);

                GridLayoutManager gridManager = new GridLayoutManager(getApplicationContext(), 2);
                binding.recyclerMain.setLayoutManager(gridManager);

                Log.e("" , "");

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });
        Log.e("" , "");






    }
}