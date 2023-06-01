package com.example.bottomnav.NewsApi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.bottomnav.NewsApi.modalClasses.Article
import com.example.bottomnav.databinding.ItemLayoutBinding

class NewsAdapter(
    private var articles: List<Article>,
    private val listener: NewsRvListener
) :
    Adapter<NewsAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.HomeViewHolder {
        return HomeViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = articles[position]
        holder.binding.newsTitle.text = item.title
        holder.binding.newsDescription.text = item.description
        Glide.with(holder.binding.newsImage.context).load(item.urlToImage)
            .into(holder.binding.newsImage)
        //data
        holder.binding.root.setOnClickListener {
            listener.onItemClicked(item)
        }
    }


    override fun getItemCount(): Int {
        return articles.size
    }


    fun updateData(data: List<Article>) {
        articles = data
        notifyItemRangeChanged(0, itemCount)
    }


}

interface NewsRvListener {
    fun onItemClicked(item: Article)
}
