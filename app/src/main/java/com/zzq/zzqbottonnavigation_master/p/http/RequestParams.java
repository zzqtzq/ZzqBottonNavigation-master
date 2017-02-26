package com.zzq.zzqbottonnavigation_master.p.http;

import java.io.File;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * User: yxfang
 * Date: 2016-04-29
 * Time: 16:55
 * ------------- Description -------------
 * ---------------------------------------
 */
public class RequestParams {

    private FormBody.Builder builder;
    private RequestBody requestBody;

//    RequestBody formBody = new MultipartBody.Builder()
//            .setType(MultipartBody.FORM)
//            .addFormDataPart("file", "", RequestBody.create(MediaType.parse("text/plain"), new File("")))
//            .addFormDataPart("account", "")
//            .addFormDataPart("yid", "")
//            .build();

    public RequestParams() {
        requestBody = new MultipartBody.Builder().build();
    }

    public void putfile(MediaType key, File value) {
        requestBody.create(key, value);
    }

    public void put(String key, String value) {
        builder.add(key, value);
    }


    public RequestBody toParams() {
        return builder.build();
    }
}
