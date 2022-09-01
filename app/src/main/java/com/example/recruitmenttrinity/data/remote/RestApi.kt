package com.example.recruitmenttrinity.data.remote

import com.example.recruitmenttrinity.data.model.ResponseUser
import retrofit2.Call
import retrofit2.http.POST

interface RestApi {
    @POST("data.json")
    fun user(): Call<MutableList<ResponseUser?>?>
}