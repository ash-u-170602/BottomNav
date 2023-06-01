package com.example.bottomnav.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnav.NewsApi.NewsAdapter
import com.example.bottomnav.NewsApi.NewsRvListener
import com.example.bottomnav.NewsApi.NewsService
import com.example.bottomnav.NewsApi.modalClasses.Article
import com.example.bottomnav.R
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentCampaignsBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CampaignsFragment : Fragment() {
    private val binding by lazy { FragmentCampaignsBinding.inflate(layoutInflater) }
    private val adapter by lazy { NewsAdapter(list, rvListener) }
    private lateinit var list: MutableList<Article>
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        getNews()
    }


    //get news
    @OptIn(DelicateCoroutinesApi::class)
    private fun getNews() {

        GlobalScope.launch(Dispatchers.IO) {
            val response =
                NewsService.newsInstance.getHeadlines(sharedViewModel.country.value.toString(), 1)
            val news = response.body()
            if (response.isSuccessful) {
                if (news != null) {
                    list.addAll(news.articles)
                    //Handle UI update on the main thread
                    withContext(Dispatchers.Main) {
                        adapter.updateData(list)
                        binding.newsList.adapter = adapter
                        binding.newsList.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private val rvListener by lazy {
        object : NewsRvListener {
            override fun onItemClicked(item: Article) {
                val url = item.url
                sharedViewModel.setUrl(url)
                val navController = findNavController()
                navController.navigate(R.id.action_campaignsFragment_to_profileFragment)
            }
        }
    }

}