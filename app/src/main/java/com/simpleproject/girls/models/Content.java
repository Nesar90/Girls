package com.simpleproject.girls.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("mp3_type")
    @Expose
    private String contentType;
    @SerializedName("mp3_title")
    @Expose
    private String contentTitle;
    @SerializedName("mp3_url")
    @Expose
    private String contentUrl;
    @SerializedName("mp3_thumbnail_b")
    @Expose
    private String contentThumbnailB;
    @SerializedName("mp3_thumbnail_s")
    @Expose
    private String contentThumbnailS;
    @SerializedName("mp3_duration")
    @Expose
    private String contentDuration;
    @SerializedName("mp3_artist")
    @Expose
    private String contentArtist;
    @SerializedName("mp3_description")
    @Expose
    private String contentDescription;
    @SerializedName("total_rate")
    @Expose
    private String totalRate;
    @SerializedName("rate_avg")
    @Expose
    private String rateAvg;
    @SerializedName("total_views")
    @Expose
    private String totalViews;
    @SerializedName("total_download")
    @Expose
    private String totalDownload;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_image_thumb")
    @Expose
    private String categoryImageThumb;


    protected Content(Parcel in) {
        id = in.readString();
        catId = in.readString();
        contentType = in.readString();
        contentTitle = in.readString();
        contentUrl = in.readString();
        contentThumbnailB = in.readString();
        contentThumbnailS = in.readString();
        contentDuration = in.readString();
        contentArtist = in.readString();
        contentDescription = in.readString();
        totalRate = in.readString();
        rateAvg = in.readString();
        totalViews = in.readString();
        totalDownload = in.readString();
        cid = in.readString();
        categoryName = in.readString();
        categoryImage = in.readString();
        categoryImageThumb = in.readString();
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentThumbnailB() {
        return contentThumbnailB;
    }

    public void setContentThumbnailB(String contentThumbnailB) {
        this.contentThumbnailB = contentThumbnailB;
    }

    public String getContentThumbnailS() {
        return contentThumbnailS;
    }

    public void setContentThumbnailS(String contentThumbnailS) {
        this.contentThumbnailS = contentThumbnailS;
    }

    public String getContentDuration() {
        return contentDuration;
    }

    public void setContentDuration(String contentDuration) {
        this.contentDuration = contentDuration;
    }

    public String getContentArtist() {
        return contentArtist;
    }

    public void setContentArtist(String contentArtist) {
        this.contentArtist = contentArtist;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(String totalDownload) {
        this.totalDownload = totalDownload;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageThumb() {
        return categoryImageThumb;
    }

    public void setCategoryImageThumb(String categoryImageThumb) {
        this.categoryImageThumb = categoryImageThumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(catId);
        parcel.writeString(contentType);
        parcel.writeString(contentTitle);
        parcel.writeString(contentUrl);
        parcel.writeString(contentThumbnailB);
        parcel.writeString(contentThumbnailS);
        parcel.writeString(contentDuration);
        parcel.writeString(contentArtist);
        parcel.writeString(contentDescription);
        parcel.writeString(totalRate);
        parcel.writeString(rateAvg);
        parcel.writeString(totalViews);
        parcel.writeString(totalDownload);
        parcel.writeString(cid);
        parcel.writeString(categoryName);
        parcel.writeString(categoryImage);
        parcel.writeString(categoryImageThumb);
    }
}
