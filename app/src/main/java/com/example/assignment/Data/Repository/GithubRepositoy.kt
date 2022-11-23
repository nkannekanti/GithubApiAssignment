package com.example.assignment.Data.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.assignment.Data.Model.GithubUser
import com.example.assignment.Data.Model.GithubUserResponse
import com.example.assignment.Data.Retrofit.GithubApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GithubRepositoy {
    val listFollwers = MutableLiveData<List<GithubUser>>()
    val listGithubUsers = MutableLiveData<List<GithubUser>>()

    fun setFollwersQuery(user: String){
        GithubApiClient.api
            .getFollwers(user)
            .enqueue(object : Callback<List<GithubUser>>
            {
                override fun onResponse(call: Call<List<GithubUser>>, response: Response<List<GithubUser>>) {
                    if(response.isSuccessful)
                    {
                        Log.d("entered","entered")
                        listFollwers.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                    Log.d("failure","fail")
                    Log.d("failure",t.message.toString())

                }


            })


    }
    fun getSearchFollwers(): MutableLiveData<List<GithubUser>>
    {
        return listFollwers
    }


    fun setSearchQuery(query: String){
        GithubApiClient.api
            .getGithubUsers(query)
            .enqueue(object :Callback<GithubUserResponse>
            {
                override fun onResponse(
                    call: Call<GithubUserResponse>,
                    response: Response<GithubUserResponse>
                ) {
                    if(response.isSuccessful)
                    {
                        listGithubUsers.postValue(response.body()?.githubUsers)
                    }

                }

                override fun onFailure(call: Call<GithubUserResponse>, t: Throwable) {
                    Log.d("failure",t.message.toString())

                }

            })
    }

    fun getSearchUsers():MutableLiveData<List<GithubUser>> {
        return listGithubUsers
    }
}