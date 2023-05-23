package com.example.parcialmoviles.ui.monument.newmonument

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcialmoviles.R
import com.example.parcialmoviles.databinding.FragmentNewMonumentBinding
import com.example.parcialmoviles.ui.monument.viewmodel.MonumentViewModel


class NewMonumentFragment : Fragment() {

    private val viewModel: MonumentViewModel by activityViewModels{
        MonumentViewModel.Factory
    }

    private lateinit var binding: FragmentNewMonumentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMonumentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(MonumentViewModel.MONUMENT_CREATED) -> {
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", viewModel.getMonument().toString())

                    viewModel.clearData()
                    viewModel.clearStatus()

                    findNavController().popBackStack()
                }
            }
        }
    }


}