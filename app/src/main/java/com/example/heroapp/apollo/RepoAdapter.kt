package com.example.heroapp.apollo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroapp.R
import com.example.heroapp.ReposQuery

class RepoAdapter(val repositories: ReposQuery.Repositories): RecyclerView.Adapter<RepoAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.repo_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RepoAdapter.ViewHolder, position: Int) {
        holder.repoName.text = repositories.nodes!![position]!!.name
        holder.numberOfStars.text = repositories.nodes[position]!!.stargazerCount.toString()
    }

    override fun getItemCount(): Int {
        return repositories.nodes?.size ?: 0
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var repoName: TextView
        var numberOfStars: TextView

        init {
            repoName = itemView.findViewById(R.id.repo_name)
            numberOfStars = itemView.findViewById(R.id.number_of_stars)
        }
    }
}