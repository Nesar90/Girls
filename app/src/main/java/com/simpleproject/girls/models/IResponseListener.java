package com.simpleproject.girls.models;

public interface IResponseListener<T> {


    void onSuccess(T responseMessage);

    void onFailure(String errorResponseMessage);


}
