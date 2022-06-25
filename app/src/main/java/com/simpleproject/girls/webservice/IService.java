package com.simpleproject.girls.webservice;

import com.simpleproject.girls.models.Category;
import com.simpleproject.girls.models.ObjectCategory;
import com.simpleproject.girls.models.ObjectContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {

    @GET("api.php?cat_list")
    Call<ObjectCategory> getMainCategoryList();

    @GET("api.php?cat_id=4")
    Call<ObjectContent> getBeautyList();

    @GET("api.php?cat_id=5")
    Call<ObjectContent> getHealthList();

    @GET("api.php?cat_id=6")
    Call<ObjectContent> getFashionList();

    @GET("api.php?cat_id=7")
    Call<ObjectContent> getWallpaperList();

    @GET("api.php?cat_id=8")
    Call<ObjectContent> getPhotographyList();

    @GET("api.php?cat_id=9")
    Call<ObjectContent> getMusicList();

    @GET("api.php?latest")
    Call<ObjectContent> getLatestList();

}
