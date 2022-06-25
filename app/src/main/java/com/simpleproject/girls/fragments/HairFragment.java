package com.simpleproject.girls.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simpleproject.girls.MainActivity;
import com.simpleproject.girls.R;
import com.simpleproject.girls.adapter.ContentAdapter;
import com.simpleproject.girls.databinding.FragmentHairBinding;
import com.simpleproject.girls.models.Content;
import com.simpleproject.girls.models.IResponseListener;
import com.simpleproject.girls.models.ObjectContent;
import com.simpleproject.girls.webservice.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;


public class HairFragment extends Fragment {

    FragmentHairBinding binding;

    WebserviceCaller webserviceCaller;

    Bundle bundle;

    public HairFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHairBinding.inflate(getLayoutInflater());
        webserviceCaller = new WebserviceCaller();
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webserviceCaller.getBeautyContentList(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.progressBarHair.setVisibility(View.INVISIBLE);

                ObjectContent objectContent = (ObjectContent) responseMessage;

                List<Content> contentList = objectContent.getContent();

                List<Content> newContent = new ArrayList<>();

                for (int i = 0 ; i < contentList.size() ; i++) {

                    if (contentList.get(i).getContentArtist().equals("hair")) {
                        newContent.add(contentList.get(i));
                    }
                }


                ContentAdapter contentAdapter = new ContentAdapter( getContext(), newContent);
                binding.recyclerHair.setAdapter(contentAdapter);

                GridLayoutManager gridManager = new GridLayoutManager(getContext(), 3);
                binding.recyclerHair.setLayoutManager(gridManager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , MainActivity.class);
                getContext().startActivity(intent);
            }
        });

    }
}