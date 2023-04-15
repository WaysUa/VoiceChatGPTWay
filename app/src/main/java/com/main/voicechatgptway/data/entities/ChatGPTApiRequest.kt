package com.main.voicechatgptway.data.entities

data class ChatGPTApiRequest(
    val model: String,
    val messages: List<ChatGPTMessage>
)