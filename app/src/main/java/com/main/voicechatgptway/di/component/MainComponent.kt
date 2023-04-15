package com.main.voicechatgptway.di.component

import com.main.voicechatgptway.di.modules.DomainModule
import com.main.voicechatgptway.di.modules.PresentationModule
import com.main.voicechatgptway.presentation.ui.MainActivity
import dagger.Component

@Component(modules = [
    PresentationModule::class,
    DomainModule::class
])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}