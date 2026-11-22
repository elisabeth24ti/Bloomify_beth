package com.example.bloomify.Konseling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloomify.R
import com.example.bloomify.databinding.FragmentChattingBinding

class ChattingFragment : Fragment() {
    private var _binding: FragmentChattingBinding? = null
    private val binding get() = _binding!!

    private val psikologList = listOf(
        PsikologModel(
            "Dr. Rina Wulandari, M.Psi.",
            "Klinis Dewasa & Kecemasan",
            "4.9",
            "(120 ulasan)",
            "Rp 150.000 / sesi",
            "https://randomuser.me/api/portraits/women/44.jpg",
            "Senin - Jumat (10:00 - 16:00)"
        ),
        PsikologModel(
            "Ahmad Fauzi, M.Psi.",
            "Hubungan & Keluarga",
            "4.8",
            "(95 ulasan)",
            "Rp 130.000 / sesi",
            "https://randomuser.me/api/portraits/men/32.jpg",
            "Selasa - Sabtu (13:00 - 20:00)"
        ),
        PsikologModel(
            "Dr. Shinta Dewi, M.Psi.",
            "Depresi & Trauma",
            "5.0",
            "(210 ulasan)",
            "Rp 200.000 / sesi",
            "https://randomuser.me/api/portraits/women/68.jpg",
            "Senin, Rabu, Jumat (09:00 - 15:00)"
        ),
        PsikologModel(
            "Reza Pratama, M.Psi.",
            "Pengembangan Diri & Karir",
            "4.7",
            "(80 ulasan)",
            "Rp 120.000 / sesi",
            "https://randomuser.me/api/portraits/men/45.jpg",
            "Kamis - Minggu (10:00 - 18:00)"
        ),
        PsikologModel(
            "Maya Lestari, M.Psi.",
            "Anak & Remaja",
            "4.9",
            "(110 ulasan)",
            "Rp 140.000 / sesi",
            "https://randomuser.me/api/portraits/women/12.jpg",
            "Selasa - Jumat (09:00 - 15:00)"
        ),
        PsikologModel(
            "Dimas Anggara, M.Psi.",
            "Adiksi & Manajemen Emosi",
            "4.6",
            "(65 ulasan)",
            "Rp 160.000 / sesi",
            "https://randomuser.me/api/portraits/men/22.jpg",
            "Senin - Sabtu (16:00 - 21:00)"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChattingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val psikologAdapter = PsikologAdapter(psikologList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih psikolog: ${selectedItem.namaPsikolog}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvPsikologChatting.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = psikologAdapter
        }
    }
}