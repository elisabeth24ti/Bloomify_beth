package com.example.bloomify.Counseling.Chat

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bloomify.R
import com.example.bloomify.databinding.ActivityBertemuLangsungBinding

class BertemuLangsungActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBertemuLangsungBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBertemuLangsungBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nama = intent.getStringExtra("NAMA_PSIKOLOG")

        binding.txtNama.text=nama
    }
}