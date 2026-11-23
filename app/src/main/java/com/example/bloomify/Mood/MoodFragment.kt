package com.example.bloomify.Mood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.bloomify.R
import com.example.bloomify.databinding.FragmentMoodBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoodFragment : Fragment() {

    private var _binding: FragmentMoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar + tombol back (sama seperti di Konseling)
        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.apply {
            title = "Mood"
            subtitle = "Pantau perasaanmu setiap hari"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.toolbar.setNavigationOnClickListener {
            requireActivity()
                .findViewById<BottomNavigationView>(R.id.bottom_nav_view)
                .selectedItemId = R.id.home
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}