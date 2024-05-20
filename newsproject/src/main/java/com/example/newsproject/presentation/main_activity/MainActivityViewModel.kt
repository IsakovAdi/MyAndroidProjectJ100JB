package com.example.newsproject.presentation.main_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.domain.cloud.model.NewsResponse
import com.example.newsproject.domain.cloud.use_cases.GetAllNewsUseCase
import com.example.newsproject.presentation.mapper.MapToUi
import com.example.newsproject.presentation.ui.NewsResponseUi
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val allNewsUseCase: GetAllNewsUseCase,
    private val mapper: MapToUi,
) : ViewModel() {
    private val _allNewsResponse: MutableLiveData<NewsResponseUi> = MutableLiveData()
    val allNewsResponse: LiveData<NewsResponseUi> get() = _allNewsResponse

    fun getAllNews() {
        viewModelScope.launch {
            val params = HashMap<String, String>()
            params.put("language", "uk")
            _allNewsResponse.value = mapper.mapNewsResponseToUi(allNewsUseCase(params = params))
        }
    }

    companion object {
        private const val SORT_ARG = "sortBy"
        private const val PUBLISHED_AT = "publishedAt"
        private const val POPULARITY = "popularity"
        private const val RELEVANCY = "relevancy"
    }
}