package com.example.assignment.Data.Retrofit

import com.example.assignment.Data.Model.GithubUser
import com.example.assignment.Data.Model.GithubUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getGithubUsers(@Query("q") query : String) : Call<GithubUserResponse>
    @GET("users/{user}/followers")
    @Headers("Authorization: token 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")
    fun getFollwers(@Path("user") user : String) : Call<List<GithubUser>>
}
