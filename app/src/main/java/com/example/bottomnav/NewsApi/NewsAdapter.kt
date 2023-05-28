package com.example.bottomnav.NewsApi

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.bottomnav.NewsApi.modalClasses.Article
import com.example.bottomnav.R
import com.example.bottomnav.SharedViewModel

class NewsAdapter(val context: Context, val articles: List<Article>) :
    Adapter<NewsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newsTitle.text = article.title

        holder.newsDescription.text = article.description

        Glide.with(context)
            .load(article.urlToImage)
            .into(holder.newsImage)

        holder.itemView.setOnClickListener {
        }
    }


    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) : ViewHolder(itemView) {

        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)

    }
}
