package com.main.voicechatgptway.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.main.voicechatgptway.domain.network.service.ChatGPTApiService

class MainViewModelFactory(
    private val chatGPTApiService: ChatGPTApiService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            chatGPTApiService = chatGPTApiService
        ) as T
    }
}