package com.example.parcialmoviles.ui.monument

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcialmoviles.R
import com.example.parcialmoviles.databinding.FragmentMonumentBinding
import com.example.parcialmoviles.ui.monument.viewmodel.MonumentViewModel


class MonumentFragment : Fragment() {

    private val viewModel: MonumentViewModel by activityViewModels{
        MonumentViewModel.Factory
    }

    private lateinit var binding: FragmentMonumentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMonumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

}