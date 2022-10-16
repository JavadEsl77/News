package com.javadesl.news.ui.home

import androidx.lifecycle.ViewModel
import com.javadesl.news.data.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

}