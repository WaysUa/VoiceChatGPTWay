package com.main.voicechatgptway.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.main.voicechatgptway.data.entities.ChatCompletionResponse
import com.main.voicechatgptway.data.entities.ChatGPTApiRequest
import com.main.voicechatgptway.domain.network.service.ChatGPTApiService
import retrofit2.await

class MainViewModel(
    private val chatGPTApiService: ChatGPTApiService
) : ViewModel() {

    suspend fun sendMessage(chatGPTApiRequest: ChatGPTApiRequest): ChatCompletionResponse? {
        val call = chatGPTApiService.sendMessage(chatGPTApiRequest)
        call?.await()
        return call?.execute()?.body()
    }
}