package com.example.bloomify.Konseling

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bloomify.R
import com.example.bloomify.databinding.ActivityOnboardingCounselingBinding

class OnboardingCounselingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingCounselingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityOnboardingCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentsList = listOf(
            Onboarding1Fragment(),
            Onboarding2Fragment(),
            Onboarding3Fragment()
        )
        val adapter = OnboardingFragmentAdapter(this, fragmentsList)
        binding.tutorialCounselingViewPager.adapter = adapter

        binding.tutorialCounselingViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialCounselingViewPager)
    }
}