package com.example.bloomify.Counseling.Chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloomify.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        ChatModel(
            "Anindya Putri, M.Psi.",
            "Psikolog klinis",
            "6 tahun",
            "Stres akademik, kecemasan",
            "4.9",
            "120 ulasan",
            "Rp60.000",
            "https://i.pravatar.cc/150?img=1",
            "Halo, selamat datang. Apa yang sedang kamu rasakan hari ini?"
        ),
        ChatModel(
            "Raka Mahendra, M.Psi.",
            "Psikolog pendidikan",
            "4 tahun",
            "Manajemen waktu, motivasi belajar",
            "4.8",
            "95 ulasan",
            "Rp50.000",
            "https://i.pravatar.cc/150?img=2",
            "Halo, ada yang ingin kamu ceritakan tentang kegiatan belajarmu?"
        ),
        ChatModel(
            namaPsikolog = "Sinta Larasati, M.Psi.",
            spesialisasi = "Psikolog klinis",
            pengalaman = "8 tahun",
            keluhan = "Kelelahan, gangguan tidur",
            rating = "4.9",
            jumlahUlasan = "210 ulasan",
            harga = "Rp75.000",
            avatarUrl = "https://i.pravatar.cc/150?img=3",
            messageText = "Halo, bagaimana kualitas tidur dan kondisi tubuhmu akhir-akhir ini?"
        ),
        ChatModel(
            namaPsikolog = "Nadia Permata, M.Psi.",
            spesialisasi = "Psikolog klinis",
            pengalaman = "5 tahun",
            keluhan = "Kecemasan, kepercayaan diri",
            rating = "4.8",
            jumlahUlasan = "105 ulasan",
            harga = "Rp55.000",
            avatarUrl = "https://i.pravatar.cc/150?img=4",
            messageText = "Halo, apa ada hal yang membuatmu merasa cemas atau kurang percaya diri?"
        ),
        ChatModel(
            namaPsikolog = "Dimas Pratama, M.Psi.",
            spesialisasi = "Psikolog pendidikan",
            pengalaman = "7 tahun",
            keluhan = "Stres belajar, motivasi",
            rating = "4.7",
            jumlahUlasan = "88 ulasan",
            harga = "Rp65.000",
            avatarUrl = "https://i.pravatar.cc/150?img=5",
            messageText = "Halo, bagaimana kegiatan belajarmu? Apakah ada kesulitan yang ingin dibahas?"
        ),
        ChatModel(
            namaPsikolog = "Maya Anggraini, M.Psi.",
            spesialisasi = "Psikolog klinis",
            pengalaman = "9 tahun",
            keluhan = "Hubungan, pengelolaan emosi",
            rating = "4.9",
            jumlahUlasan = "185 ulasan",
            harga = "Rp80.000",
            avatarUrl = "https://i.pravatar.cc/150?img=6",
            messageText = "Halo, kamu bisa bercerita tentang hubungan atau perasaan yang sedang kamu alami."
        ),
        ChatModel(
            namaPsikolog = "Fajar Ramadhan, M.Psi.",
            spesialisasi = "Psikolog industri",
            pengalaman = "4 tahun",
            keluhan = "Stres kerja, pengembangan diri",
            rating = "4.7",
            jumlahUlasan = "76 ulasan",
            harga = "Rp50.000",
            avatarUrl = "https://i.pravatar.cc/150?img=7",
            messageText = "Halo, apakah ada hal terkait pekerjaan atau pengembangan diri yang ingin kamu diskusikan?"
        ),
        ChatModel(
            namaPsikolog = "Citra Maharani, M.Psi.",
            spesialisasi = "Psikolog klinis",
            pengalaman = "6 tahun",
            keluhan = "Gangguan tidur, kecemasan",
            rating = "4.8",
            jumlahUlasan = "132 ulasan",
            harga = "Rp60.000",
            avatarUrl = "https://i.pravatar.cc/150?img=8",
            messageText = "Halo, bagaimana keadaanmu hari ini? Ada yang ingin kamu ceritakan?"
        ),
        ChatModel(
            namaPsikolog = "Bagas Saputra, M.Psi.",
            spesialisasi = "Psikolog pendidikan",
            pengalaman = "3 tahun",
            keluhan = "Kesulitan belajar, fokus",
            rating = "4.6",
            jumlahUlasan = "64 ulasan",
            harga = "Rp45.000",
            avatarUrl = "https://i.pravatar.cc/150?img=9",
            messageText = "Halo, apakah kamu sedang mengalami kesulitan untuk fokus atau memahami pelajaran?"
        ),
        ChatModel(
            namaPsikolog = "Putri Amelia, M.Psi.",
            spesialisasi = "Psikolog klinis",
            pengalaman = "7 tahun",
            keluhan = "Kepercayaan diri, stres",
            rating = "4.9",
            jumlahUlasan = "156 ulasan",
            harga = "Rp70.000",
            avatarUrl = "https://i.pravatar.cc/150?img=10",
            messageText = "Halo, apa yang sedang membuatmu merasa stres atau kurang percaya diri?"
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChatAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}