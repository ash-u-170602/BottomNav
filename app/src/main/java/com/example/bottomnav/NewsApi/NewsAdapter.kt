package com.example.bottomnav.NewsApi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.bottomnav.NewsApi.modalClasses.Article
import com.example.bottomnav.R

class NewsAdapter(
    private val context: Context,
    private val articles: List<Article>,
    private val listener: OnItemClickListener
) :
    Adapter<NewsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        val viewHolder = ArticleViewHolder(view)
        view.setOnClickListener {
            listener.onItemClick(articles)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newsTitle.text = article.title

        holder.newsDescription.text = article.description

        Glide.with(context)
            .load(article.urlToImage)
            .into(holder.newsImage)
    }


    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View) : ViewHolder(itemView) {

        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        var newsDescription: TextView = itemView.findViewById(R.id.newsDescription)
    }

    interface OnItemClickListener {
        fun onItemClick(articles: List<Article>)
    }

}
