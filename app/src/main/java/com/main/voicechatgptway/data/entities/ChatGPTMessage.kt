package com.main.voicechatgptway.data.entities

data class ChatGPTMessage(
    val role: String = "user",
    val content: String
)