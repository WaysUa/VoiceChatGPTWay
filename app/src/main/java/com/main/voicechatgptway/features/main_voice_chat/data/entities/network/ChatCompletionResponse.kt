package com.main.voicechatgptway.features.main_voice_chat.data.entities.network

import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.ChatMessage
import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.MessageType

data class ChatCompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val choices: List<ChatChoice>,
    val usage: ChatUsage
) {
    fun mapToChatMessage(): ChatMessage {
        return ChatMessage(choices[0].message.content, messageType = MessageType.CHAT_GPT_MESSAGE)
    }
}