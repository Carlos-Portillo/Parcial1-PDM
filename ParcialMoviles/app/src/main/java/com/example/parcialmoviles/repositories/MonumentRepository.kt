package com.example.parcialmoviles.repositories

import com.example.parcialmoviles.data.model.MonumentModel

class MonumentRepository(private val monuments: MutableList<MonumentModel>) {
    fun getMonuments() = monuments

    fun addMonuments(monument: MonumentModel) = monuments.add(monument)
}