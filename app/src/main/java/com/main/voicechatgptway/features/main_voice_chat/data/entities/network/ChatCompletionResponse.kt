package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

data class ChatCompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val choices: List<ChatChoice>,
    val usage: ChatUsage
)