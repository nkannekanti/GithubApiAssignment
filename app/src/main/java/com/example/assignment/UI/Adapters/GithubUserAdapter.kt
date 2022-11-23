package com.example.assignment.UI.Adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.assignment.Data.Model.GithubUser
import com.example.assignment.databinding.ItemGithubuserBinding
import com.example.assignment.UI.View.FollwersActivity

class GithubUserAdapter: RecyclerView.Adapter<GithubUserAdapter.GithubUserViewHolder>() {

    private val githuberUserlist = ArrayList<GithubUser>()

    fun setList(githubUsers:List<GithubUser>)
    {
        githuberUserlist.clear()
        githuberUserlist.addAll(githubUsers)
        notifyDataSetChanged()
    }

    class GithubUserViewHolder(val binding: ItemGithubuserBinding) : RecyclerView.ViewHolder(binding.root)
    {
         fun bind(githubUser: GithubUser)
         {
             binding.apply {
                 Glide.with(itemView)
                     .load(githubUser.avatar_url)
                     .transition(DrawableTransitionOptions.withCrossFade())
                     .centerCrop()
                     .into(avatar)
                 username.text = githubUser.login

             }
             binding.githubUserview.setOnClickListener {
                 val intent = Intent(binding.root.context, FollwersActivity::class.java)
                 intent.putExtra("user",githubUser.login)
                 Log.d("userd",githubUser.login)
                 binding.root.context.startActivity(intent)
             }

         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
       val view = ItemGithubuserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GithubUserViewHolder(view)
    }
    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
         holder.bind(githuberUserlist[position])
    }

    override fun getItemCount(): Int {
        return githuberUserlist.size
    }



}