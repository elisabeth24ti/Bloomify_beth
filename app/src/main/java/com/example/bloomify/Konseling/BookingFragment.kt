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
import com.example.bloomify.databinding.FragmentBookingBinding


class BookingFragment : Fragment() {
    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private val psikologList = listOf(
        PsikologModel(
            "Dr. Rina Wulandari, M.Psi.",
            "Klinis Dewasa & Kecemasan",
            "4.9",
            "(120 ulasan)",
            "Rp 150.000 / 1 Jam",
            "https://randomuser.me/api/portraits/women/65.jpg", // Perempuan
            "Senin - Jumat (10:00 - 16:00)"
        ),
        PsikologModel(
            "Ahmad Fauzi, M.Psi.",
            "Konflik pernikahan, masalah keluarga",
            "4.8",
            "(95 ulasan)",
            "Rp 130.000 / 1 Jam",
            "https://randomuser.me/api/portraits/men/36.jpg", // Laki-laki
            "Selasa - Sabtu (13:00 - 20:00)"
        ),
        PsikologModel(
            "Dr. Shinta Dewi, M.Psi.",
            "Depresi & Trauma",
            "5.0",
            "(210 ulasan)",
            "Rp 200.000 / 2 Jam",
            "https://randomuser.me/api/portraits/women/44.jpg", // Perempuan
            "Senin, Rabu, Jumat (09:00 - 15:00)"
        ),
        PsikologModel(
            "Reza Pratama, M.Psi.",
            "Pengembangan Diri & Karir",
            "4.7",
            "(80 ulasan)",
            "Rp 120.000 / 1 Jam",
            "https://randomuser.me/api/portraits/men/52.jpg", // Laki-laki
            "Kamis - Minggu (10:00 - 18:00)"
        ),
        PsikologModel(
            "Maya Lestari, M.Psi.",
            "Anak & Remaja",
            "4.9",
            "(110 ulasan)",
            "Rp 140.000 / 1 Jam",
            "https://randomuser.me/api/portraits/women/28.jpg", // Perempuan
            "Selasa - Jumat (09:00 - 15:00)"
        ),
        PsikologModel(
            "Dimas Anggara, M.Psi.",
            "Adiksi & Manajemen Emosi",
            "4.6",
            "(65 ulasan)",
            "Rp 160.000 / 1.5 Jam",
            "https://randomuser.me/api/portraits/men/22.jpg", // Laki-laki
            "Senin - Sabtu (16:00 - 21:00)"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kamu bisa menggunakan adapter yang sama atau adapter khusus psikolog
        val bookingAdapter = PsikologAdapter(psikologList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Melihat detail booking dengan: ${selectedItem.namaPsikolog}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvPsikologBooking.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = bookingAdapter
        }
    }
}