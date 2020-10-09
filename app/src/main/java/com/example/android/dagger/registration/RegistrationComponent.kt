package com.example.android.dagger.registration

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface RegistrationComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
   interface Factory {
        fun create(): RegistrationComponent
    }

    // Injekatala se bude u sve te 3 classe: 1) RegistrationActivity, 2) EnterDetailsFragment, 3) TermsAndConiditionsFragment
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}