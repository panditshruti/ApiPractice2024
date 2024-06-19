package com.shruti.apipractice.api

import com.shruti.apipractice.db.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface UserInterface {

    @GET("posts")
    fun getUser(): Call<UserItem>

}