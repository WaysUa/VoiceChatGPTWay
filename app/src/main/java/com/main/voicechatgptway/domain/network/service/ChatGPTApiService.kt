package com.main.voicechatgptway.domain.network.service

import com.main.voicechatgptway.BuildConfig
import com.main.voicechatgptway.data.entities.ChatCompletionResponse
import com.main.voicechatgptway.data.entities.ChatGPTApiRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatGPTApiService {

    @POST("v1/chat/completions")
    fun sendMessage(
        @Body request: ChatGPTApiRequest?,
        @Header("Authorization") authHeader: String? = BuildConfig.API_KEY,
        @Header("Content-Type") contentType: String = "application/json"
    ): Call<ChatCompletionResponse>?


    companion object {
        const val BASE_URL = "https://api.openai.com/"
    }
}