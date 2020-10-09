package com.example.android.dagger.splash

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent

// Scope annotation that the SplashComponent uses
@ActivityScope
@Subcomponent
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplashActivity)
}