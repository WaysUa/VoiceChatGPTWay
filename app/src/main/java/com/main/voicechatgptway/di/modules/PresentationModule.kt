package com.main.voicechatgptway.di.modules

import com.main.voicechatgptway.domain.network.service.ChatGPTApiService
import com.main.voicechatgptway.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideMainViewModelFactory(
        chatGPTApiService: ChatGPTApiService
    ): MainViewModelFactory {
        return MainViewModelFactory(
            chatGPTApiService = chatGPTApiService
        )
    }

}