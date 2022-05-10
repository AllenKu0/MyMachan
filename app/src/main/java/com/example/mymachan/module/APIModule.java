package com.example.mymachan.module;

import android.content.Context;

import com.example.mymachan.R;
import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.utils.api.soap.requestValue.RequestValue;
import com.example.mymachan.utils.api.soap.requestValue.RequestValueProvider;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public abstract class APIModule {

    @Provides
    @Singleton
    static ErpAPI provideErpRemoteResource(@Named("ErpApi") Retrofit retrofit){
        return retrofit.create(ErpAPI.class);
    }

    @Provides
    @Singleton
    static MachanAPI provideMachanRemoteResource(@Named("MachanApi") Retrofit retrofit){
        return retrofit.create(MachanAPI.class);
    }

    @Provides
    @Singleton
    @Named("ErpApi")
    static Retrofit provideErpApiRetrofit(@Named("ErpApiURL") String url,
                                    @Named("ErpApiClient") OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("MachanApi")
    static Retrofit provideMachanApiRetrofit(@Named("MachanApiURL") String url,
                                    @Named("MachanApiClient") OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("ErpApiURL")
    static String prevideErpApiURL(Context context){
        return context.getResources().getString(R.string.link_erp_api_url);
    }

    @Provides
    @Singleton
    @Named("MachanApiURL")
    static String prevideMachanApiURL(Context context){
        return context.getResources().getString(R.string.link_machan_api_url);
    }

    @Provides
    @Singleton
    @Named("ErpApiClient")
    static OkHttpClient provideErpApiClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                      @Named("ErpApiHeader")Interceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @Named("MachanApiClient")
    static OkHttpClient provideMachanApiClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                               @Named("MachanApiHeader")Interceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @Named("ErpApiHeader")
    static Interceptor provideErpApiHeader() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder()
                        .header("Content-Type", "text/xml")
                        .build());
            }
        };
    }

    @Provides
    @Singleton
    @Named("MachanApiHeader")
    static Interceptor provideMachanApiHeader() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6Im1hY2hhbiIsIlRpbWVzdGFtcCI6IlwvRGF0ZSgxNjE4NTUxODk1OTAwKVwvIn0.IGtum8FvC7-9oOaNKjAvQiXb9ZiMboBLHvH4ku7uQjQ")
                        .build());
            }
        };
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    static RequestValueProvider provideRequestValueProvider(RequestValue requestValue){
        return requestValue;
    }
}
