package com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService

class MainVoiceChatViewModelFactory(
    private val mainVoiceChatGPTApiService: MainVoiceChatGPTApiService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainVoiceChatViewModel(
            mainVoiceChatGPTApiService = mainVoiceChatGPTApiService
        ) as T
    }
}