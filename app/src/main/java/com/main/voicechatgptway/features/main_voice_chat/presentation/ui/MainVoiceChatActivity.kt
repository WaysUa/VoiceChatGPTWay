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
import com.main.voicechatgptway.features.main_voice_chat.data.entities.ChatGPTApiRequest
import com.main.voicechatgptway.features.main_voice_chat.data.entities.ChatGPTMessage
import com.main.voicechatgptway.di.provider.ProvideMainComponent
import com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel.MainVoiceChatViewModel
import com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel.MainVoiceChatViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

class MainVoiceChatActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChatVoiceMainBinding.inflate(layoutInflater) }
    private var launcher by Delegates.notNull<ActivityResultLauncher<Intent>>()

    @Inject
    lateinit var mainVoiceChatViewModelFactory: MainVoiceChatViewModelFactory
    private val mainVoiceChatViewModel: MainVoiceChatViewModel by viewModels { mainVoiceChatViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (applicationContext as ProvideMainComponent).provideMainComponent().inject(this)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode != RESULT_OK) return@registerForActivityResult

            val content = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0).toString()
            val chatGPTApiRequest = ChatGPTApiRequest(
                messages = listOf(ChatGPTMessage(content = content))
            )
            lifecycleScope.launch(Dispatchers.IO) {
                val response = mainVoiceChatViewModel.sendMessage(chatGPTApiRequest)
                Log.d("MyLog", response.toString())
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