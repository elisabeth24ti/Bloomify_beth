package com.example.bloomify.Konseling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bloomify.databinding.ItemPsikologBinding

class PsikologAdapter (
    private val psikologList: List<PsikologModel>,
    private val onItemClick: (PsikologModel) -> Unit
    ) : RecyclerView.Adapter<PsikologAdapter.ProductViewHolder>() {
        inner class ProductViewHolder(val binding: ItemPsikologBinding) :
            RecyclerView.ViewHolder(binding.root)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val binding = ItemPsikologBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return ProductViewHolder(binding)
        }
        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val item = psikologList[position]
            with(holder.binding) {
                tvNamaPsikolog.text = item.namaPsikolog
                tvSpesialisasi.text = item.spesialisasi
                tvRating.text = item.rating
                tvJumlahUlasan.text = item.jumlahUlasan
                tvJadwal.text = item.jadwal
                tvHarga.text = item.harga
                Glide.with(holder.itemView.context)
                    .load(item.avatarUrl)
                    .into(imgAvatar)
                root.setOnClickListener { onItemClick(item) }
            }
        }
        override fun getItemCount(): Int = psikologList.size
    }
