package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

data class ChatChoice(
    val index: Int,
    val message: ChatMessage,
    val finish_reason: String
)