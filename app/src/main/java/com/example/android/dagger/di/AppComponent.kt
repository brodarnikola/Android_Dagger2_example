package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserComponent
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
// Definition of a Dagger component that adds info from the StorageModule to the graph
// na taj nacin komponenta(@Component) moze doci do informacija koje se nalaze u StorageModule class
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        // Prije smo imali gresku da nismo imali instanciran Context u SharedPreferencesStorage
        // Zato nam application graph nije prolazio.
        // Context je provijdan od android system-a i zato je kreiran izvan application grapha
        // Context je u to vrijeme dostupan, zato smo tu napravili instancu koju smo kasnije proslijedili
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Types that can be retrieved from the graph
    // Expose RegistrationComponent factory from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    // Expose LoginComponent factory from the graph
    fun loginComponent(): LoginComponent.Factory

    // 2) Expose UserManager so that MainActivity and SettingsActivity
    // can access a particular instance of UserComponent
    fun userManager(): UserManager
}