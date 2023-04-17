package com.main.voicechatgptway.di.modules

import com.main.voicechatgptway.features.main_voice_chat.domain.network.service.MainVoiceChatGPTApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class DomainModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MainVoiceChatGPTApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(5L, TimeUnit.MINUTES)
            .writeTimeout(5L, TimeUnit.MINUTES)
            .readTimeout(5L, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    fun provideMainVoiceChatGPTApiService(
        retrofit: Retrofit
    ): MainVoiceChatGPTApiService {
        return retrofit.create(MainVoiceChatGPTApiService::class.java)
    }
}