package com.example.bloomify.Counseling

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bloomify.R
import com.example.bloomify.databinding.ActivityTutorialCounselingBinding

class TutorialCounselingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialCounselingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityTutorialCounselingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialCounselingViewPager.adapter = adapter

        binding.tutorialCounselingViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialCounselingViewPager)
    }
}