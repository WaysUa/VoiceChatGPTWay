package com.main.voicechatgptway.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.main.voicechatgptway.BuildConfig
import com.main.voicechatgptway.data.entities.ChatGPTApiRequest
import com.main.voicechatgptway.data.entities.ChatGPTMessage
import com.main.voicechatgptway.databinding.ActivityMainBinding
import com.main.voicechatgptway.domain.network.service.ChatGPTApiService
import com.main.voicechatgptway.domain.network.service.ChatGPTApiService.Companion.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var launcher by Delegates.notNull<ActivityResultLauncher<Intent>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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