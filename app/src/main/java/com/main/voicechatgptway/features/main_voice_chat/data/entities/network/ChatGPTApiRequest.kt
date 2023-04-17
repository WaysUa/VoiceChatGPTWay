package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

data class ChatGPTApiRequest(
    val model: String = "gpt-3.5-turbo",
    val messages: List<ChatGPTMessage>
)