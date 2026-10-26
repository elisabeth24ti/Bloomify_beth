package com.example.bloomify.Counseling.Chat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.bloomify.databinding.ItemBertemulangsungBinding

class BertemuLangsungAdapter(
    context: Context,
    private val bertemulangsung: List<BertemuLangsungModel>
) : ArrayAdapter<BertemuLangsungModel>(context, 0, bertemulangsung) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemBertemulangsungBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = bertemulangsung[position]

        // Muat gambar dari URL ke ImageView
        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textnamaPsikolog.text = data.namaPsikolog
        binding.textSpesialisasi.text = "${data.spesialisasi} · ${data.pengalaman}"
        binding.textKeluhan.text = data.keluhan
        binding.textRating.text = "${data.rating} (${data.jumlahUlasan})"
        binding.textHarga.text = data.harga

        view.setOnClickListener {
            val i = Intent(context, BertemuLangsungActivity::class.java)
            i.putExtra("NAMA_PSIKOLOG", data.namaPsikolog)
            context.startActivity(i)

//            Snackbar.make(
//                parent,
//                "Informasi psikolog: ${data.namaPsikolog}",
//                Snackbar.LENGTH_SHORT
//            ).show()
        }

        return view
    }
}