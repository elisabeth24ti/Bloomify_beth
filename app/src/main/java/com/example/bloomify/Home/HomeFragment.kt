package com.example.bloomify.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.bloomify.Counseling.Chat.KonselingFragment
import com.example.bloomify.Counseling.CounselingFragment
import com.example.bloomify.Journal.DetailActivity
import com.example.bloomify.Journal.JournalActivity
import com.example.bloomify.LoginActivity
import com.example.bloomify.R
import com.example.bloomify.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = sharedPref.getString("username", "")

        binding.txtUsername.text = user

        binding.btnJournal.setOnClickListener {
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }
        binding.btnKonseling.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CounselingFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnlogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}





