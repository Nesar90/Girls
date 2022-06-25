package com.simpleproject.girls.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.simpleproject.girls.R;
import com.simpleproject.girls.adapter.ContentAdapter;
import com.simpleproject.girls.adapter.FragmentsAdapter;
import com.simpleproject.girls.adapter.HealthAdapter;
import com.simpleproject.girls.adapter.MusicAdapter;
import com.simpleproject.girls.databinding.ActivityContentBinding;
import com.simpleproject.girls.fragments.HairFragment;
import com.simpleproject.girls.fragments.MakeupFragment;
import com.simpleproject.girls.fragments.NailFragment;
import com.simpleproject.girls.models.IResponseListener;
import com.simpleproject.girls.models.ObjectContent;
import com.simpleproject.girls.webservice.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {

    ActivityContentBinding binding;

    Bundle bundle;

    WebserviceCaller webserviceCaller;

    String catId;

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();

        catId = bundle.getString("cat_Id");

        title = bundle.getString("title");

        webserviceCaller = new WebserviceCaller();

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        switch (catId) {

            case "4":

                binding.fragmentPager.setVisibility(View.VISIBLE);
                binding.bottomNav.setVisibility(View.VISIBLE);

                List<Fragment> fragmentList = new ArrayList<>();

                fragmentList.add(new HairFragment());
                fragmentList.add(new MakeupFragment());
                fragmentList.add(new NailFragment());

                FragmentsAdapter adapter = new FragmentsAdapter(this, fragmentList);
                binding.fragmentPager.setAdapter(adapter);

                binding.fragmentPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);

                        switch (position) {
                            case 0:
                                binding.bottomNav.getMenu().findItem(R.id.item_hair).setChecked(true);
                                break;

                            case 1:
                                binding.bottomNav.getMenu().findItem(R.id.item_makeup).setChecked(true);
                                break;

                            case 2:
                                binding.bottomNav.getMenu().findItem(R.id.item_nail).setChecked(true);
                                break;
                        }

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        super.onPageScrollStateChanged(state);
                    }
                });

                binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.item_hair:
                                binding.fragmentPager.setCurrentItem(0);
                                binding.bottomNav.getMenu().findItem(R.id.item_hair).setChecked(true);
                                break;

                            case R.id.item_makeup:
                                binding.fragmentPager.setCurrentItem(1);
                                binding.bottomNav.getMenu().findItem(R.id.item_makeup).setChecked(true);
                                break;

                            case R.id.item_nail:
                                binding.fragmentPager.setCurrentItem(2);
                                binding.bottomNav.getMenu().findItem(R.id.item_nail).setChecked(true);
                                break;
                        }

                        return false;
                    }
                });



            break;

            case "5":
                binding.recyclerContent.setVisibility(View.VISIBLE);
                binding.toolbarContent.setVisibility(View.VISIBLE);
                binding.txtTitle.setText(title);

                webserviceCaller.getHealthContentList(new IResponseListener() {
                    @Override
                    public void onSuccess(Object responseMessage) {

                        ObjectContent objectContent = (ObjectContent) responseMessage;

                        HealthAdapter healthAdapter = new HealthAdapter( getApplicationContext() , objectContent.getContent());
                        binding.recyclerContent.setAdapter(healthAdapter);

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, true);
                        binding.recyclerContent.setLayoutManager(linearLayoutManager);

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                });
                break;

            case "6":
                binding.recyclerContent.setVisibility(View.VISIBLE);
                binding.toolbarContent.setVisibility(View.VISIBLE);
                binding.txtTitle.setText(title);

                webserviceCaller.getFashionContentList(new IResponseListener() {
                    @Override
                    public void onSuccess(Object responseMessage) {

                        ObjectContent objectContent = (ObjectContent) responseMessage;

                        ContentAdapter contentAdapter = new ContentAdapter( getApplicationContext() , objectContent.getContent());
                        binding.recyclerContent.setAdapter(contentAdapter);

                        GridLayoutManager gridManager = new GridLayoutManager(getApplicationContext(), 3);
                        binding.recyclerContent.setLayoutManager(gridManager);

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                });
                break;

            case "7":
                binding.recyclerContent.setVisibility(View.VISIBLE);
                binding.toolbarContent.setVisibility(View.VISIBLE);
                binding.txtTitle.setText(title);

                webserviceCaller.getWallpaperContentList(new IResponseListener() {
                    @Override
                    public void onSuccess(Object responseMessage) {

                        ObjectContent objectContent = (ObjectContent) responseMessage;

                        ContentAdapter contentAdapter = new ContentAdapter( getApplicationContext() , objectContent.getContent());
                        binding.recyclerContent.setAdapter(contentAdapter);

                        GridLayoutManager gridManager = new GridLayoutManager(getApplicationContext(), 3);
                        binding.recyclerContent.setLayoutManager(gridManager);

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                });
                break;

            case "8":
                binding.recyclerContent.setVisibility(View.VISIBLE);
                binding.toolbarContent.setVisibility(View.VISIBLE);
                binding.txtTitle.setText(title);

                webserviceCaller.getPhotographyContentList(new IResponseListener() {
                    @Override
                    public void onSuccess(Object responseMessage) {


                        ObjectContent objectContent = (ObjectContent) responseMessage;

                        ContentAdapter contentAdapter = new ContentAdapter( getApplicationContext() , objectContent.getContent());
                        binding.recyclerContent.setAdapter(contentAdapter);

                        GridLayoutManager gridManager = new GridLayoutManager(getApplicationContext(), 3);
                        binding.recyclerContent.setLayoutManager(gridManager);

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                });
                break;

            case "9":
                binding.recyclerContent.setVisibility(View.VISIBLE);
                binding.toolbarContent.setVisibility(View.VISIBLE);
                binding.txtTitle.setText(title);

                webserviceCaller.getMusicContentList(new IResponseListener() {
                    @Override
                    public void onSuccess(Object responseMessage) {

                        ObjectContent objectContent = (ObjectContent) responseMessage;

                        MusicAdapter musicAdapter = new MusicAdapter( getApplicationContext() , objectContent.getContent());
                        binding.recyclerContent.setAdapter(musicAdapter);

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, true);
                        binding.recyclerContent.setLayoutManager(linearLayoutManager);

                    }

                    @Override
                    public void onFailure(String errorResponseMessage) {

                    }
                });
                break;

        }


    }
}