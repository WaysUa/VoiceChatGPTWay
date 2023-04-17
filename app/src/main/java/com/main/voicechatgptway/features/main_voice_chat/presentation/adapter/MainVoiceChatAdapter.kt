package com.main.voicechatgptway.features.main_voice_chat.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.voicechatgptway.R
import com.main.voicechatgptway.databinding.ItemChatgptMessageBinding
import com.main.voicechatgptway.databinding.ItemUserMessageBinding
import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.ChatMessage
import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.MessageType

class MainVoiceChatAdapter : RecyclerView.Adapter<MainVoiceChatAdapter.MainVoiceChatViewHolder>() {
    private val messages = mutableListOf<ChatMessage>()

    class MainVoiceChatViewHolder(view: View): ViewHolder(view) {
        private val chatGptMessageBinding by lazy { ItemChatgptMessageBinding.bind(view) }
        private val userMessageBinding by lazy { ItemUserMessageBinding.bind(view) }

        fun bind(chatMessage: ChatMessage) {
            if (chatMessage.messageType == MessageType.USER_MESSAGE) {

            }
            if (chatMessage.messageType == MessageType.CHAT_GPT_MESSAGE) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVoiceChatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if (viewType == MessageType.USER_MESSAGE.ordinal) {
            MainVoiceChatViewHolder(layoutInflater.inflate(R.layout.item_user_message, parent, false))
        } else  {
            MainVoiceChatViewHolder(layoutInflater.inflate(R.layout.item_chatgpt_message, parent, false))
        }
    }

    override fun onBindViewHolder(holder: MainVoiceChatViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].messageType == MessageType.USER_MESSAGE) {
            MessageType.USER_MESSAGE.ordinal
        } else {
            MessageType.CHAT_GPT_MESSAGE.ordinal
        }
    }

    override fun getItemCount() = messages.size
}