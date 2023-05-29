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
import com.example.bottomnav.NewsApi.NewsService
import com.example.bottomnav.NewsApi.modalClasses.News
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentCampaignsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CampaignsFragment : Fragment(), NewsAdapter.OnItemClickListener {
    private val binding by lazy { FragmentCampaignsBinding.inflate(layoutInflater) }
    lateinit var adapter: NewsAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var news: News

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getNews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //get news
    private fun getNews() {

        val newsService =
            NewsService.newsInstance.getHeadlines(sharedViewModel.homeData.value.toString(), 1)

        newsService.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    adapter = NewsAdapter(requireContext(), news.articles, this)
                    binding.newsList.adapter = adapter
                    binding.newsList.layoutManager = LinearLayoutManager(requireContext())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_LONG).show()
            }
        })

    }

    // Handle clicks
    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "${news.articles[position].url} sex", Toast.LENGTH_SHORT).show()
    }
}