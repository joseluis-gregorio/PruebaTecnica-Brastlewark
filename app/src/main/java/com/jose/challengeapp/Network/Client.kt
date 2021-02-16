package com.jose.challengeapp.Network

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.itkacher.okprofiler.BuildConfig
import com.jose.challengeapp.Network.AuthGeneralInter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client{

    fun getClient(url: String): Retrofit {
        val GGClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(AuthGeneralInter())
        if (BuildConfig.DEBUG){
            GGClient.addInterceptor(OkHttpProfilerInterceptor())
        }
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(GGClient.build())
            .build()
        return retrofit
    }
}