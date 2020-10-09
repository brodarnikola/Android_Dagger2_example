package com.example.android.dagger.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val userManager = (application as MyApplication).appComponent.userManager()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if( !userManager.isUserLoggedIn() ) {
            if( !userManager.isUserRegistered() ) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            }
            else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        else {
            userManager.userJustLoggedIn()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }



}


