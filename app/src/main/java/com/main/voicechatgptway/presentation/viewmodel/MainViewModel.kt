package com.main.voicechatgptway.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.voicechatgptway.data.entities.ChatGPTApiRequest
import com.main.voicechatgptway.domain.network.service.ChatGPTApiService

class MainViewModel(
    private val chatGPTApiService: ChatGPTApiService
) : ViewModel() {

    fun sendMessage(chatGPTApiRequest: ChatGPTApiRequest) {
        chatGPTApiService.sendMessage(chatGPTApiRequest)
    }
}