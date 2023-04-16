package com.main.voicechatgptway.di.modules

import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService
import com.main.voicechatgptway.features.main_voice_chat.presentation.viewmodel.MainVoiceChatViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideMainVoiceChatViewModelFactory(
        mainVoiceChatGPTApiService: MainVoiceChatGPTApiService
    ): MainVoiceChatViewModelFactory {
        return MainVoiceChatViewModelFactory(
            mainVoiceChatGPTApiService = mainVoiceChatGPTApiService
        )
    }

}