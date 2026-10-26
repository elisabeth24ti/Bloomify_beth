package com.example.bloomify.Counseling.Chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloomify.databinding.FragmentBertemulangsungBinding

class BertemuLangsungFragment : Fragment() {
    private var _binding: FragmentBertemulangsungBinding? = null
    private val binding get() = _binding!!
    private val psikologList = listOf(
        BertemuLangsungModel(
            "Dewi Anggraini, M.Psi.",
            "Psikolog klinis",
            "6 tahun",
            "Stres akademik, kecemasan",
            "4.9",
            "120 ulasan",
            "Rp150.000",
            "https://i.pravatar.cc/150?img=47",
            "Senin–Jumat, 09.00–15.00"
        ),
        BertemuLangsungModel(
            "Arif Nugraha, M.Psi.",
            "Psikolog pendidikan",
            "4 tahun",
            "Manajemen waktu, motivasi belajar",
            "4.8",
            "95 ulasan",
            "Rp125.000",
            "https://i.pravatar.cc/150?img=12",
            "Senin–Sabtu, 10.00–16.00"
        ),
        BertemuLangsungModel(
            "Clara Maharani, M.Psi.",
            "Psikolog klinis",
            "8 tahun",
            "Kelelahan, gangguan tidur",
            "4.9",
            "210 ulasan",
            "Rp200.000",
            "https://i.pravatar.cc/150?img=44",
            "Senin–Jumat, 08.00–14.00"
        ),
        BertemuLangsungModel(
            "Fitria Safitri, M.Psi.",
            "Psikolog klinis",
            "5 tahun",
            "Kecemasan, kepercayaan diri",
            "4.8",
            "105 ulasan",
            "Rp150.000",
            "https://i.pravatar.cc/150?img=49",
            "Selasa–Sabtu, 09.00–15.00"
        ),
        BertemuLangsungModel(
            "Reza Firmansyah, M.Psi.",
            "Psikolog pendidikan",
            "7 tahun",
            "Stres belajar, motivasi",
            "4.7",
            "88 ulasan",
            "Rp175.000",
            "https://i.pravatar.cc/150?img=13",
            "Senin–Jumat, 13.00–19.00"
        ),
        BertemuLangsungModel(
            "Nabila Putri, M.Psi.",
            "Psikolog klinis",
            "9 tahun",
            "Hubungan, pengelolaan emosi",
            "4.9",
            "185 ulasan",
            "Rp225.000",
            "https://i.pravatar.cc/150?img=45",
            "Senin–Sabtu, 09.00–16.00"
        ),
        BertemuLangsungModel(
            "Andika Pratama, M.Psi.",
            "Psikolog industri",
            "4 tahun",
            "Stres kerja, pengembangan diri",
            "4.7",
            "76 ulasan",
            "Rp125.000",
            "https://i.pravatar.cc/150?img=14",
            "Senin–Jumat, 10.00–17.00"
        ),
        BertemuLangsungModel(
            "Vania Lestari, M.Psi.",
            "Psikolog klinis",
            "6 tahun",
            "Gangguan tidur, kecemasan",
            "4.8",
            "132 ulasan",
            "Rp175.000",
            "https://i.pravatar.cc/150?img=48",
            "Senin–Jumat, 09.00–15.00"
        ),
        BertemuLangsungModel(
            "Rizky Aditya, M.Psi.",
            "Psikolog pendidikan",
            "3 tahun",
            "Kesulitan belajar, fokus",
            "4.6",
            "64 ulasan",
            "Rp100.000",
            "https://i.pravatar.cc/150?img=15",
            "Senin–Sabtu, 13.00–18.00"
        ),
        BertemuLangsungModel(
            "Shania Permata, M.Psi.",
            "Psikolog klinis",
            "7 tahun",
            "Kepercayaan diri, stres",
            "4.9",
            "156 ulasan",
            "Rp200.000",
            "https://i.pravatar.cc/150?img=46",
            "Selasa–Sabtu, 09.00–16.00"
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBertemulangsungBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BertemuLangsungAdapter(requireContext(), psikologList)
        binding.listMessageItems.adapter = adapter
    }
}