package com.shruti.apipractice.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shruti.apipractice.api.UserInterface
import com.shruti.apipractice.db.UserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserModel :ViewModel(){
    var userLiveData = MutableLiveData<UserItem>()


    fun getUserModel(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(UserInterface::class.java)
        val call = apiService.getUser()

        call.enqueue(object : Callback<UserItem> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<UserItem>, response: Response<UserItem>) {
                if (response.isSuccessful) {
                    val users = response.body()
                     userLiveData.value = users
                    Log.d("MyApi", "user id is "+ users!![0].id)
                } else {
                    Log.d("MyApi", "Response not successful")
                }
            }

            override fun onFailure(call: Call<UserItem>, t: Throwable) {
                Log.d("MyApi", "Request failed", t)
            }
        })


    }


}