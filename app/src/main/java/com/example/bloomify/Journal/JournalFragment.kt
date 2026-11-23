package com.example.bloomify.Journal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloomify.R
import com.example.bloomify.databinding.FragmentJournalBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.bloomify.databinding.DialogJournalFormBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import data.AppDatabase
import data.entity.JournalEntity
import kotlinx.coroutines.launch
import com.google.android.material.chip.Chip

class JournalFragment : Fragment() {
    private var _binding: FragmentJournalBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: JournalAdapter
    private val journals = mutableListOf<JournalEntity>()
    private var selectedMood: String? = null   // null = tampilkan semua

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJournalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Journal"

        db = AppDatabase.getInstance(requireContext())
        adapter = JournalAdapter(journals) { journal -> deleteJournal(journal) }
        binding.rvJournal.addItemDecoration(
            DividerItemDecoration(
                requireContext(), DividerItemDecoration.VERTICAL
            )
        )
        binding.rvJournal.layoutManager = LinearLayoutManager(requireContext())
        binding.rvJournal.adapter = adapter

        binding.btntambahJournal.setOnClickListener {
            showFormDialog()
        }

        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.apply {
            title = "Journal"
            subtitle ="Ceritakan harimu di sini"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.toolbar.setNavigationOnClickListener {
            requireActivity()
                .findViewById<BottomNavigationView>(R.id.bottom_nav_view)
                .selectedItemId = R.id.home
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull() // ambil id chip yang dipilih
            selectedMood = if (selectedChipId != null) {
                group.findViewById<Chip>(selectedChipId).text.toString()
            } else {
                null // tidak ada chip dipilih -> tampilkan semua
            }
            fetchJournals()
            if (savedInstanceState == null && arguments?.getBoolean("open_form") == true) {
                showFormDialog()
            }
        }

        fetchJournals()
    }

    private fun showFormDialog() {
        val dialogBinding = DialogJournalFormBinding.inflate(layoutInflater)
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Tambah Journal")
            .setView(dialogBinding.root)
            .setNegativeButton("Batal", null)
            .setPositiveButton("Simpan", null)
            .show()
        dialog.getButton(android.content.DialogInterface.BUTTON_POSITIVE)
            .setOnClickListener {
                val title = dialogBinding.etTitle.text.toString().trim()
                val content = dialogBinding.etContent.text.toString().trim()
                val chip = dialogBinding.chipGroupMood
                    .findViewById<Chip>(dialogBinding.chipGroupMood.checkedChipId)
                val mood = chip.text.toString()
                if (title.isBlank() || content.isBlank()) {
                    Toast.makeText(
                        requireContext(), "Isi semua kolom!", Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                insertJournal(title, content, mood)
                dialog.dismiss()
            }
    }

    private fun insertJournal(title: String, content: String, mood: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                db.journalDao().insert(
                    JournalEntity(title = title, content = content, mood = mood)
                )
                fetchJournals()
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(), "Gagal menyimpan journal", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun fetchJournals() {
        viewLifecycleOwner.lifecycleScope.launch {
            val mood = selectedMood
            val result = if (mood == null) {
                db.journalDao().getAll()
            } else {
                db.journalDao().getByMood(mood)
            }
            journals.clear()
            journals.addAll(result)
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteJournal(journal: JournalEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.journalDao().delete(journal)
            fetchJournals()
        }
    }

    override fun onDestroyView() {
        binding.rvJournal.adapter = null
        _binding = null
        super.onDestroyView()
    }
}