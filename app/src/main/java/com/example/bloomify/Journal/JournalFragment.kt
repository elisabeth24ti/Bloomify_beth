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
import com.example.bloomify.databinding.FragmentJournalBinding

class JournalFragment : Fragment() {
    private var _binding: FragmentJournalBinding? = null
    private val binding get() = _binding!!

    private val dataList = listOf(
        "Kamis, 8 Okt",
        "Jumat, 9 Okt",
        "Sabtu, 10 Okt",
        "Minggu, 11 Okt",
        "Senin, 12 Okt",
        "Selasa, 13 Okt",
        "Rabu, 14 Okt",
        "Kamis, 15 Okt"
    )
    private val dataListWithDesc = listOf(
        mapOf("date" to "Kamis, 8 Okt", "desc" to "Laporan akhirnya selesai"),
        mapOf("date" to "Jumat, 9 Okt", "desc" to "Jurnal kegiatan hari ini"),
        mapOf("date" to "Sabtu, 10 Okt", "desc" to "Menyelesaikan tugas kuliah"),
        mapOf("date" to "Minggu, 11 Okt", "desc" to "Belajar pemrograman Kotlin"),
        mapOf("date" to "Senin, 12 Okt", "desc" to "Mengerjakan proyek Bloomify"),
        mapOf("date" to "Selasa, 13 Okt", "desc" to "Evaluasi kegiatan mingguan"),
        mapOf("date" to "Rabu, 14 Okt", "desc" to "Membaca materi perkuliahan"),
        mapOf("date" to "Kamis, 15 Okt", "desc" to "Menyusun jadwal belajar")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJournalBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Journal"

//        // Adapter: penghubung dataList dengan layout simple_list_item_1
//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
//// Hubungkan listViewItems dengan adapter
//        binding.listViewItems.adapter = adapter
//// Aksi saat item diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem",
//                Toast.LENGTH_SHORT).
//                show()
//        }
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("date", "desc"), // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.btntambahJournal.setOnClickListener {
            startActivity(Intent(requireActivity(), DetailActivity::class.java))
        }
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val date = selectedItem["date"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $date($desc)",
                Toast.LENGTH_SHORT).show()
        }
    }
}