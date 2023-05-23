package com.example.parcialmoviles.ui.monument.catalog.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialmoviles.data.model.MonumentModel
import com.example.parcialmoviles.data.monuments
import com.example.parcialmoviles.databinding.MonumentItemBinding


class MonumentRecyclerViewAdapter(
    private val clickListener: (MonumentModel) -> Unit
): RecyclerView.Adapter<MonumentRecyclerViewHolder>() {
    private val monuments = ArrayList<MonumentModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonumentRecyclerViewHolder {
        val binding = MonumentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonumentRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return monuments.size
    }

    override fun onBindViewHolder(holder: MonumentRecyclerViewHolder, position: Int) {
        val monument = monuments[position]
        holder.bind(monument, clickListener)
    }

    fun setData(computersList: List<MonumentModel>) {
        monuments.clear()
        monuments.addAll(computersList)
    }


}