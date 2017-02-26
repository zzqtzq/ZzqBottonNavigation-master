package com.zzq.zzqbottonnavigation_master.IModel;

import android.content.Context;

import com.zzq.zzqbottonnavigation_master.p.http.HttpRequestCallback;
import com.zzq.zzqbottonnavigation_master.p.http.HttpRequestUtil;
import com.zzq.zzqbottonnavigation_master.p.http.RequestParams;

import okhttp3.FormBody;

/**
 * Created by 志强 on 2017.2.14.
 */

public abstract class BaseModel implements IBaseModel {
    /**
     * 发送http get 请求
     *
     * @param context
     * @param url
     * @param callback
     */
    protected void sendGetRequest(Context context, String url, HttpRequestCallback callback) {
        HttpRequestUtil.getInstance().getRequest(context, getAbsUrl(url), callback);
    }

    protected void sendGetRequest2(Context context, String url, HttpRequestCallback callback) {
        HttpRequestUtil.getInstance().getRequest(context, url, callback);
    }

    /**
     * 发送http post 请求
     *
     * @param context
     * @param url
     * @param params
     * @param callback
     */
    protected void sendPostRequest(Context context, String url, RequestParams params, HttpRequestCallback callback) {
        HttpRequestUtil.getInstance().postRequest(context, getAbsUrl(url), params == null ? null : (FormBody) params.toParams(), callback);
    }


    /**
     * 发送http post 请求
     *
     * @param context
     * @param url
     * @param params
     * @param callback
     */
    protected void sendPostRequest2(Context context, String url, RequestParams params, HttpRequestCallback callback) {
        HttpRequestUtil.getInstance().postRequest(context, url, params == null ? null : (FormBody) params.toParams(), callback);
    }

    private String getAbsUrl(String url) {
        return SERVER_ADDRESS + url;
    }
}
