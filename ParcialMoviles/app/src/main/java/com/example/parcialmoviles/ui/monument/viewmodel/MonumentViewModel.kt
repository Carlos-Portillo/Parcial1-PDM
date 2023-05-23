package com.example.parcialmoviles.ui.monument.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcialmoviles.MonumentReviewerApplication
import com.example.parcialmoviles.data.model.MonumentModel
import com.example.parcialmoviles.repositories.MonumentRepository

class MonumentViewModel(private val repository: MonumentRepository): ViewModel() {
    var name = MutableLiveData("")
    var ubication = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMonument() = repository.getMonuments()

    fun addMonument(monument: MonumentModel) = repository.addMonuments(monument)

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            ubication.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createMonument() {
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val newMonument = MonumentModel(
            name.value.toString(),
            ubication.value.toString()
        )

        addMonument(newMonument)
        status.value = MONUMENT_CREATED
    }

    fun clearData() {
        name.value = ""
        ubication.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MonumentReviewerApplication
                MonumentViewModel(app.monumentRepository)
            }
        }
        const val MONUMENT_CREATED = "Monument created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}