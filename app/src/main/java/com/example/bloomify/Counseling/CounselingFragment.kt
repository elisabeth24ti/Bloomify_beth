package com.example.bloomify.Counseling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.bloomify.Counseling.Chat.BertemuLangsungFragment
import com.example.bloomify.Counseling.Chat.ChatFragment
import com.example.bloomify.databinding.FragmentCounselingBinding

class CounselingFragment : Fragment() {
    private var _binding: FragmentCounselingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCounselingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = "Konseling"
        binding.toolbar.subtitle = "Pilih psikolog anda"

        replaceFragment(ChatFragment())

        binding.btnFragment1.setOnClickListener {
            replaceFragment(ChatFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(BertemuLangsungFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}



