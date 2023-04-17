package com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.voicechatgptway.features.main_voice_chat.data.entities.network.ChatCompletionResponse
import com.main.voicechatgptway.features.main_voice_chat.data.entities.network.ChatGPTApiRequest
import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService

class MainVoiceChatViewModel(
    private val mainVoiceChatGPTApiService: MainVoiceChatGPTApiService
) : ViewModel() {

    suspend fun sendMessage(chatGPTApiRequest: ChatGPTApiRequest): ChatCompletionResponse? {
        val response = mainVoiceChatGPTApiService.sendMessage(chatGPTApiRequest)
        return response.body()
    }
}