package com.example.assignment.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.Data.Model.GithubUser
import com.example.assignment.Data.Repository.GithubRepositoy

class MainViewModel: ViewModel() {
    var listGithubUsers: MutableLiveData<List<GithubUser>>?=null

    fun setSearchQuery(query: String){
        GithubRepositoy.setSearchQuery(query)
    }

    fun getSearchUsers():LiveData<List<GithubUser>>
    {
        listGithubUsers = GithubRepositoy.getSearchUsers()
        return listGithubUsers as LiveData<List<GithubUser>>
    }
}