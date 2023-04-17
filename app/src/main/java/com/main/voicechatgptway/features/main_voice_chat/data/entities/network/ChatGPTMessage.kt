package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

data class ChatGPTMessage(
    val role: String = "user",
    val content: String
)