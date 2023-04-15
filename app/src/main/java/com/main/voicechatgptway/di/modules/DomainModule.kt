package com.main.voicechatgptway.di.modules

import com.main.voicechatgptway.domain.network.service.ChatGPTApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DomainModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ChatGPTApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideChatGPTApiService(
        retrofit: Retrofit
    ): ChatGPTApiService {
        return retrofit.create(ChatGPTApiService::class.java)
    }
}