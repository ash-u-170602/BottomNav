package com.example.bottomnav.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnav.NewsApi.NewsAdapter
import com.example.bottomnav.NewsApi.NewsRvListener
import com.example.bottomnav.NewsApi.NewsService
import com.example.bottomnav.NewsApi.modalClasses.Article
import com.example.bottomnav.NewsApi.modalClasses.News
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentCampaignsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CampaignsFragment : Fragment() {
    private val binding by lazy { FragmentCampaignsBinding.inflate(layoutInflater) }
    private val adapter by lazy { NewsAdapter(list, rvListener) }
    private lateinit var list: MutableList<Article>
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        getNews()
    }

    //get news
    private fun getNews() {

        val newsService =
            NewsService.newsInstance.getHeadlines(sharedViewModel.country.value.toString(), 1)
        newsService.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    list = ArrayList()
                    list.addAll(news.articles)
                    binding.newsList.adapter = adapter
                    adapter.updateData(list)
                    binding.newsList.layoutManager = LinearLayoutManager(requireContext())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_LONG).show()
            }

        })

    }

    private val rvListener by lazy {
        object : NewsRvListener {
            override fun onItemClicked(item: Article) {
                val url = item.url
                sharedViewModel.setUrl(url)


            }

        }
    }

}