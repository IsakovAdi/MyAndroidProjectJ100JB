package com.example.newsproject.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.presentation.ui.NewsUi

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {
    var news = mutableListOf<NewsUi>()

    inner class NewsAdapterViewHolder(view:View):RecyclerView.ViewHolder(view) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    fun setNewsList(data:List<NewsUi>){
        news.clear()
        news.addAll(data)
        notifyDataSetChanged()
    }
}


