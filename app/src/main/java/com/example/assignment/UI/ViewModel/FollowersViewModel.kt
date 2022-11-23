package com.example.assignment.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.Data.Model.GithubUser
import com.example.assignment.Data.Repository.GithubRepositoy

class FollowersViewModel: ViewModel() {
    var listFollwers :MutableLiveData<List<GithubUser>>?=null

    fun setFollwersQuery(user:String){
        GithubRepositoy.setFollwersQuery(user)
    }

    fun getSearchFollwers(): LiveData<List<GithubUser>>
    {   listFollwers = GithubRepositoy.getSearchFollwers()
        return listFollwers as LiveData<List<GithubUser>>
    }
}