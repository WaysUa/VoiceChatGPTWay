package com.main.voicechatgptway.features.main_voice_chat.domain.mapper

import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.ChatMessage

interface MainVoiceChatAdapterMapper {

    fun map(chatMessage: ChatMessage)

    fun mapAll(newMessages: List<ChatMessage>)
}