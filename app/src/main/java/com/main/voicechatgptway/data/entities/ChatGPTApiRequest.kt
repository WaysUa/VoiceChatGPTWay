package com.main.voicechatgptway.data.entities

data class ChatGPTApiRequest(
    val model: String = "gpt-3.5-turbo",
    val messages: List<ChatGPTMessage>
)