package com.javadesl.news.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javadesl.news.data.NewsRepository
import com.javadesl.news.data.news.News
import com.javadesl.news.helper.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val network: NetworkHelper
) : ViewModel() {

    private val _liveDataNews = MutableStateFlow<News?>(null)
    val liveDataNews = _liveDataNews.asStateFlow()
    fun getNews(action: String) = viewModelScope.launch {
        if (network.hasInternetConnection()) {
            val response = newsRepository.getNews(action)
            _liveDataNews.emit(response)
        } else {
            _liveDataNews.emit(null)
        }
    }

}
