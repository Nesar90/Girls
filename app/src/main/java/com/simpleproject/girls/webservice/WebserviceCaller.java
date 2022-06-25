package com.simpleproject.girls.webservice;

import com.simpleproject.girls.models.Category;
import com.simpleproject.girls.models.IResponseListener;
import com.simpleproject.girls.models.ObjectCategory;
import com.simpleproject.girls.models.ObjectContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

    public WebserviceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getCategoryList(IResponseListener listener) {

        iService.getMainCategoryList().enqueue(new Callback<ObjectCategory>() {
            @Override
            public void onResponse(Call<ObjectCategory> call, Response<ObjectCategory> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectCategory> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }


    public void getLatestContentList(IResponseListener listener) {

        iService.getLatestList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getBeautyContentList(IResponseListener listener) {

        iService.getBeautyList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getHealthContentList(IResponseListener listener) {

        iService.getHealthList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getFashionContentList(IResponseListener listener) {

        iService.getFashionList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getWallpaperContentList(IResponseListener listener) {

        iService.getWallpaperList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getPhotographyContentList(IResponseListener listener) {

        iService.getPhotographyList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

    public void getMusicContentList(IResponseListener listener) {

        iService.getMusicList().enqueue(new Callback<ObjectContent>() {
            @Override
            public void onResponse(Call<ObjectContent> call, Response<ObjectContent> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ObjectContent> call, Throwable t) {
                listener.onFailure("ERROR");
            }
        });

    }

}
