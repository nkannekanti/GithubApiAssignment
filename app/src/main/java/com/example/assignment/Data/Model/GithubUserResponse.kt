package com.example.assignment.Data.Model

import com.example.assignment.Data.Model.GithubUser
import com.google.gson.annotations.SerializedName

data class GithubUserResponse(
    @SerializedName("items")
    val githubUsers: List<GithubUser>)
