package com.main.voicechatgptway.di.modules

import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DomainModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MainVoiceChatGPTApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideMainVoiceChatGPTApiService(
        retrofit: Retrofit
    ): MainVoiceChatGPTApiService {
        return retrofit.create(MainVoiceChatGPTApiService::class.java)
    }
}