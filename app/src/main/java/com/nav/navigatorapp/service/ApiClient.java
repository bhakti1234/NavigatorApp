package com.nav.navigatorapp.service;

import android.content.Context;
import android.util.Log;


import com.nav.navigatorapp.pojo.request.LoginData;
import com.nav.navigatorapp.pojo.request.ReqLogin;
import com.nav.navigatorapp.pojo.request.ReqRegister;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nav.navigatorapp.Constants.BASE_URL;


public class ApiClient {

    private static final String TAG = ApiClient.class.getSimpleName();
    private static ApiClient apiClient;
    private static ApiInterface service;
    private static Retrofit retrofit;
    private static ApiClient billingClient;
    private static Retrofit billingRetrofit;
    private ApiClient(){}

    private static Context my_conext;
    private static String apiHeaderKey;

    public ApiClient (Context context) {
        my_conext = context;
    }

    public static ApiClient getInstance() {

        if (apiClient==null) {
            apiClient = new ApiClient();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();

            service = retrofit.create(ApiInterface.class);
        }
        return apiClient;
    }

    private static OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().build();
                return chain.proceed(request);
            }
        });
        builder.addInterceptor(logging);
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }

    public Call<LoginData> getLogin(ReqLogin reqLogin) {
        Call<LoginData> getLogin = null;
        try {
            getLogin = service.getLogin(reqLogin);
        }catch (Exception e){
            Log.e(TAG, e.getMessage(), e);
        }
        return getLogin;
    }
//
    public Call<String> register(ReqRegister reqRegister) {
        Call<String> register = null;
        try {
            register = service.register(reqRegister);
        }catch (Exception e){
            Log.e(TAG, e.getMessage(), e);
        }
        return register;
    }
//
//    public Call<ResSubscribedUserDetails> getSubscribedPlan(ReqSubscribedUser reqSubscribedUser) {
//        Call<ResSubscribedUserDetails> getSubscribedPlan = null;
//        try {
//            getSubscribedPlan = service.getSubscribedPlanDetails(reqSubscribedUser);
//        }catch (Exception e){
//            Log.e(TAG, e.getMessage(), e);
//        }
//        return getSubscribedPlan;
//    }


}
