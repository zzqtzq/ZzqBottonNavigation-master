package com.zzq.zzqbottonnavigation_master.api;


import com.zzq.zzqbottonnavigation_master.common.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class HttpClient {

    private final HttpApi mHttpApi;

    public HttpClient() {


        String BaseUrl = Constants.isTest ? Constants.ZhiHuUrl : Constants.ZhiHuUrl;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(OkHttpManager.getInstance())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        mHttpApi = retrofit.create(HttpApi.class);
    }

    public HttpApi getHttpApi() {
        return mHttpApi;
    }
}
