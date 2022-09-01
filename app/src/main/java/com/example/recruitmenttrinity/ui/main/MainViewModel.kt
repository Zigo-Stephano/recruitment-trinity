package com.example.recruitmenttrinity.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recruitmenttrinity.data.model.ResponseUser
import com.example.recruitmenttrinity.data.remote.RestConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val users = MutableLiveData<MutableList<ResponseUser?>?>()

    fun requestUser() {
        val request = RestConfig.getRestApi().user()
        request.enqueue(object : Callback<MutableList<ResponseUser?>?> {

            override fun onResponse(
                call: Call<MutableList<ResponseUser?>?>,
                response: Response<MutableList<ResponseUser?>?>
            ) {
                Log.d("MainRespon", "onResponse: ${response.body()}")
                users.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<ResponseUser?>?>, t: Throwable) {
                val user: MutableList<ResponseUser?>? = null
                users.postValue(user)
            }

        })
    }

    fun responseUser(): LiveData<MutableList<ResponseUser?>?> {
        return users
    }

}