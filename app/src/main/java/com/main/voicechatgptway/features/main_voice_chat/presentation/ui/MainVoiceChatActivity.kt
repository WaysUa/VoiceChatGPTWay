package com.main.voicechatgptway.features.main_voice_chat.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.main.voicechatgptway.databinding.ActivityChatVoiceMainBinding
import com.main.voicechatgptway.features.main_voice_chat.data.entities.network.ChatGPTApiRequest
import com.main.voicechatgptway.features.main_voice_chat.data.entities.network.ChatGPTMessage
import com.main.voicechatgptway.di.provider.ProvideMainComponent
import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.ChatMessage
import com.main.voicechatgptway.features.main_voice_chat.data.entities.local.MessageType
import com.main.voicechatgptway.features.main_voice_chat.presentation.adapter.MainVoiceChatAdapter
import com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel.MainVoiceChatViewModel
import com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel.MainVoiceChatViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.properties.Delegates

class MainVoiceChatActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChatVoiceMainBinding.inflate(layoutInflater) }
    private var launcher by Delegates.notNull<ActivityResultLauncher<Intent>>()

    @Inject
    lateinit var mainVoiceChatViewModelFactory: MainVoiceChatViewModelFactory
    private val mainVoiceChatViewModel: MainVoiceChatViewModel by viewModels { mainVoiceChatViewModelFactory }
    private val mainVoiceChatAdapter = MainVoiceChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (applicationContext as ProvideMainComponent).provideMainComponent().inject(this)
        binding.rvMessages.adapter = mainVoiceChatAdapter

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode != RESULT_OK) return@registerForActivityResult

            val content = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0).toString()
            mainVoiceChatAdapter.map(ChatMessage(message = content, MessageType.USER_MESSAGE))
            val chatGPTApiRequest = ChatGPTApiRequest(
                messages = listOf(ChatGPTMessage(content = content))
            )
            lifecycleScope.launch(Dispatchers.IO) {
                val response = mainVoiceChatViewModel.sendMessage(chatGPTApiRequest)
                withContext(Dispatchers.Main) {
                    response?.mapToChatMessage()?.let { mainVoiceChatAdapter.map(it) }
                    binding.rvMessages.scrollToPosition(mainVoiceChatAdapter.itemCount - 1)
                }
            }
        }

        binding.btnSpeak.setOnClickListener {
            speak()
        }
    }

    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking")
        launcher.launch(intent)
    }
}