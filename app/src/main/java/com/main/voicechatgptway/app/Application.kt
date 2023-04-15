package com.main.voicechatgptway.app

import android.app.Application
import com.main.voicechatgptway.di.component.DaggerMainComponent
import com.main.voicechatgptway.di.component.MainComponent
import com.main.voicechatgptway.di.modules.DomainModule
import com.main.voicechatgptway.di.modules.PresentationModule
import com.main.voicechatgptway.di.provider.ProvideMainComponent

class Application : Application(), ProvideMainComponent {

    private val mainComponent: MainComponent by lazy {
        DaggerMainComponent
            .builder()
            .presentationModule(PresentationModule())
            .domainModule(DomainModule())
            .build()
    }
    override fun provideMainComponent() = mainComponent
}