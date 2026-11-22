package com.example.bloomify.Journal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloomify.databinding.FragmentJournalBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.bloomify.databinding.DialogJournalFormBinding
import data.AppDatabase
import data.entity.JournalEntity
import kotlinx.coroutines.launch

class JournalFragment : Fragment() {
    private var _binding: FragmentJournalBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: JournalAdapter
    private val journals = mutableListOf<JournalEntity>()

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
        // dipasang setelah show() supaya dialog tidak menutup kalau input belum diisi
        dialog.getButton(android.content.DialogInterface.BUTTON_POSITIVE)
            .setOnClickListener {
                val title = dialogBinding.etTitle.text.toString().trim()
                val content = dialogBinding.etContent.text.toString().trim()
                if (title.isBlank() || content.isBlank()) {
                    Toast.makeText(
                        requireContext(), "Isi semua kolom!", Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                insertJournal(title, content)
                dialog.dismiss()
            }
    }

    private fun insertJournal(title: String, content: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                db.journalDao().insert(
                    JournalEntity(title = title, content = content)
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
            val result = db.journalDao().getAll()
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