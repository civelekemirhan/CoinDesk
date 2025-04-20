package com.example.coindesk.common.di

import com.example.coindesk.common.api.CoinDeskApi
import com.example.coindesk.common.util.Constant.API_KEY
import com.example.coindesk.common.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val originalUrl = original.url

            val urlWithApiKey = originalUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY) // ← API anahtarını URL'e ekler
                .build()

            val request = original.newBuilder()
                .url(urlWithApiKey)
                .build()

            chain.proceed(request)
        }
        .build()


    @Provides
    fun provideCoinDeskApi(retrofit: Retrofit): CoinDeskApi {
        return retrofit.create(CoinDeskApi::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}