package com.main.voicechatgptway.data.entities

data class ChatUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)