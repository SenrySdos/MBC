package mbc.sdos.es.mbc.di.modules;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mbc.sdos.es.mbc.BuildConfig;
import mbc.sdos.es.mbc.data.ws.MBCWs;
import mbc.sdos.es.mbc.data.ws.restadapter.interceptor.CoreRequestInterceptor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class ApiModule {

    public static final String CACHE_FILE_NAME = "http_cache";
    private static final Integer DISK_CACHE_SIZE = 25 * 1024 * 1024; // 25 MB

    private final static String WS_VERSION = "1";
    private static String ENDPOINT = " http://descargas.sdos.es/";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application, Interceptor interceptor) {
        File cacheDir = new File(application.getCacheDir(), CACHE_FILE_NAME);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(cacheDir, DISK_CACHE_SIZE));

        return builder.build();
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)

                .create();
    }

    @Provides
    public Interceptor getInterceptor() {
        CoreRequestInterceptor requestInterceptor = new CoreRequestInterceptor();
        requestInterceptor.setVersionHeader(BuildConfig.VERSION_NAME);
        return requestInterceptor;
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson));

        return builder.build();
    }

    @Provides
    public MBCWs provideInditexWS(Retrofit retrofit) {
        return retrofit.create(MBCWs.class);
    }

    public static void setENDPOINT(String ENDPOINT) {
        ApiModule.ENDPOINT = ENDPOINT + WS_VERSION + "/";
    }

    public static String getENDPOINT() {
        return ENDPOINT;
    }
}