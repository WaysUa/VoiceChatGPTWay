package com.main.voicechatgptway.data.entities

data class ChatChoice(
    val index: Int,
    val message: ChatMessage,
    val finish_reason: String
)