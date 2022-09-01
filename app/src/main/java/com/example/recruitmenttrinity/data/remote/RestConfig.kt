package com.example.recruitmenttrinity.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestConfig {
    companion object {
        fun getRestApi(): RestApi {
            val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )).build()
            val api = Retrofit.Builder()
                .baseUrl("https://webzigo.000webhostapp.com/trinity/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return api.create(RestApi::class.java)
        }
    }
}