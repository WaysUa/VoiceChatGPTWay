package com.main.voicechatgptway.data.entities

data class ChatCompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val choices: List<ChatChoice>,
    val usage: ChatUsage
)