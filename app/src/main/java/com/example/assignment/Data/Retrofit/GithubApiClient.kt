package com.example.assignment.Data.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiClient {
    private const val BASE_URL = "https://api.github.com/"
    val api : GithubApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }
}