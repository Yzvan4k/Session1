package com.example.delete1ses

import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("SignIn")
    fun login(@Body b:LogB):retrofit2.Call<responstoken>
    @POST("SignUp")
    fun reg(@Body b:RegB):retrofit2.Call<responstoken>
}