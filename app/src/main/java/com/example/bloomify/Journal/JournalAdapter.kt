package com.example.bloomify.Journal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloomify.databinding.ItemJournalBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import data.entity.JournalEntity

class JournalAdapter(
    private val journals: List<JournalEntity>,
    private val onDelete: (JournalEntity) -> Unit
) : RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {
    class JournalViewHolder(val binding: ItemJournalBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JournalViewHolder {
        val binding = ItemJournalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return JournalViewHolder(binding)
    }
    override fun onBindViewHolder(
        holder: JournalViewHolder,
        position: Int
    ) {
        val journal = journals[position]
        holder.binding.tvTitle.text = journal.title
        holder.binding.tvContent.text = journal.content
        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Journal")
                .setMessage("Yakin ingin menghapus journal ini?")
                .setPositiveButton("Ya") { _, _ -> onDelete(journal) }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
    override fun getItemCount(): Int = journals.size
}