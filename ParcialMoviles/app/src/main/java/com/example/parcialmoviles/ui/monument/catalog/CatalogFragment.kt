package com.example.parcialmoviles.ui.monument.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialmoviles.R
import com.example.parcialmoviles.data.model.MonumentModel
import com.example.parcialmoviles.databinding.FragmentCatalogBinding
import com.example.parcialmoviles.ui.monument.catalog.recyclerview.MonumentRecyclerViewAdapter
import com.example.parcialmoviles.ui.monument.viewmodel.MonumentViewModel


class CatalogFragment : Fragment() {

    private val monumentViewModel: MonumentViewModel by activityViewModels{
        MonumentViewModel.Factory
    }

    private lateinit var binding: FragmentCatalogBinding
    private lateinit var adapter: MonumentRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            monumentViewModel.clearData()
            it.findNavController().navigate(R.id.action_catalogFragment_to_newMonumentFragment)
        }
    }

    private fun showSelectedItem(monument: MonumentModel){
        monumentViewModel.setSelectedMonument(monument)
        findNavController().navigate(R.id.action_catalogFragment_to_monumentFragment)
    }

    private fun displayComputers() {
        adapter.setData(monumentViewModel.getMonument())
        adapter.notifyDataSetChanged()
    }

    /*private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MonumentRecyclerViewAdapter {selectedMonument ->
            showSelectedItem(selectedMonument)
        }

        binding.recyclerView.adapter = adapter
        displayComputers()
    }*/

}