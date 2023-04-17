package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

data class ChatUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)