package com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.voicechatgptway.features.main_voice_chat.data.entities.ChatCompletionResponse
import com.main.voicechatgptway.features.main_voice_chat.data.entities.ChatGPTApiRequest
import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService
import retrofit2.await

class MainVoiceChatViewModel(
    private val mainVoiceChatGPTApiService: MainVoiceChatGPTApiService
) : ViewModel() {

    suspend fun sendMessage(chatGPTApiRequest: ChatGPTApiRequest): ChatCompletionResponse? {
        val call = mainVoiceChatGPTApiService.sendMessage(chatGPTApiRequest)
        call?.await()
        return call?.execute()?.body()
    }
}