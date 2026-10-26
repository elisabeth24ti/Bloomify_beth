package com.example.bloomify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bloomify.Counseling.CounselingFragment
import com.example.bloomify.Focus.FocusFragment
import com.example.bloomify.Home.HomeFragment
import com.example.bloomify.Journal.JournalFragment
import com.example.bloomify.Mood.MoodFragment
import com.example.bloomify.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        replaceFragment(HomeFragment()) //ketika dijalankan yang muncul pertama ya tampilan homefragmen
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.focus -> {
                    replaceFragment(FocusFragment())
                    true
                }
                R.id.mood -> {
                    replaceFragment(MoodFragment())
                    true
                }
                R.id.journal -> {
                    replaceFragment(JournalFragment())
                    true
                }
                R.id.counseling -> {
                    replaceFragment(CounselingFragment())
                    true
                }
                else -> false // false jika item tidak dikenal
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            // .addToBackStack(null) sengaja dinonaktifkan: saat back langsung keluar aplikasi
            .commit()
    }
}