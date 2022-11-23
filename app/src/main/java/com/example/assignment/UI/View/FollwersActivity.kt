package com.example.assignment.UI.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.databinding.ActivityFollwersBinding
import com.example.assignment.UI.ViewModel.FollowersViewModel
import com.example.assignment.UI.Adapters.GithubUserAdapter

class FollwersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFollwersBinding
    private lateinit var viewModel: FollowersViewModel
    private lateinit var adapter: GithubUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollwersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = GithubUserAdapter()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            FollowersViewModel::class.java)
        adapter = GithubUserAdapter()
        adapter.notifyDataSetChanged()
        binding.apply {
            followersView.layoutManager = LinearLayoutManager(this@FollwersActivity)
            followersView.setHasFixedSize(true)
            followersView.adapter = adapter
            searcFollowers()

        }
        viewModel.getSearchFollwers().observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }

        }


    }
    private fun searcFollowers()
    {   val intent = getIntent()
        val user = intent.getStringExtra("user")
        if (user != null) {
            Log.d("user",user)
        }
        binding.apply {
            if (user != null) {
                Log.d("debug","entering set")
                viewModel.setFollwersQuery(user)
            }
        }
    }
}