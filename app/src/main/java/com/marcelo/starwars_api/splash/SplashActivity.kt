package com.marcelo.starwars_api.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.onboarding.OnboardingActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    val background = intArrayOf(
        R.drawable.starwars_image1,
        R.drawable.starwars_image2,
        R.drawable.starwars_image4,
        R.drawable.starwars_image5
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getRandomBackground(applicationContext)
        Handler().postDelayed({
            starWelcomeScreen()
        }, 3000.toLong())

    }

    private fun getRandomBackground(context: Context){
        splash_background.background = ContextCompat.getDrawable(context, background.random())
    }

    private fun starWelcomeScreen(){
        startActivity(OnboardingActivity.getStartIntent(this))
        finish()
    }
}