package com.example.assignment.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.UI.Adapters.GithubUserAdapter
import com.example.assignment.UI.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: GithubUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = GithubUserAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        binding.apply {
            githubUsersView.layoutManager = LinearLayoutManager(this@MainActivity)
            githubUsersView.setHasFixedSize(true)
            githubUsersView.adapter = adapter
            search.setOnClickListener {
              searchGithubUser()
            }

            query.setOnKeyListener { view, i, keyEvent ->
                if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    searchGithubUser()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false

            }
        }
        viewModel.getSearchUsers().observe(this) {
            it?.let {
                adapter.setList(it)
                showProgressBar(false)
            }

        }
    }
    private fun searchGithubUser()
    {
        binding.apply {
            val query = query.text.toString()
            if(query.isEmpty()) return
            showProgressBar(true)
            viewModel.setSearchQuery(query)
        }
    }
    private fun showProgressBar(state:Boolean)
    {
        if(state)
        {
            binding.progressbar.visibility = View.VISIBLE

        }else{
            binding.progressbar.visibility = View.GONE
        }
    }
}