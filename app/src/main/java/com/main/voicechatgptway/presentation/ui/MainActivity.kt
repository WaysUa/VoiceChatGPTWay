package com.main.voicechatgptway.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.main.voicechatgptway.databinding.ActivityMainBinding
import com.main.voicechatgptway.di.provider.ProvideMainComponent
import com.main.voicechatgptway.presentation.viewmodel.MainViewModel
import com.main.voicechatgptway.presentation.viewmodel.MainViewModelFactory
import javax.inject.Inject
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var launcher by Delegates.notNull<ActivityResultLauncher<Intent>>()

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val mainViewModel: MainViewModel by viewModels { mainViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (applicationContext as ProvideMainComponent).provideMainComponent().inject(this)

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