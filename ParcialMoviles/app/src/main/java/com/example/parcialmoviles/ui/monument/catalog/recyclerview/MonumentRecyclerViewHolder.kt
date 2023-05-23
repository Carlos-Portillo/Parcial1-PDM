package com.example.parcialmoviles.ui.monument.catalog.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmoviles.data.model.MonumentModel
import com.example.parcialmoviles.databinding.MonumentItemBinding

class MonumentRecyclerViewHolder(private val binding: MonumentItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(computer: MonumentModel, clickListener: (MonumentModel) -> Unit) {
        binding.nameTextView.text = computer.name
        binding.ubicationTextView.text = computer.ubication

        binding.monumentCardView.setOnClickListener {
            clickListener(computer)
        }
    }
}