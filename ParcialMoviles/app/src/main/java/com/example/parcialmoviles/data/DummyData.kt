package com.example.parcialmoviles.data

import com.example.parcialmoviles.data.model.MonumentModel

val name = "Monte Saint-Michel"
val ubication = "isla de la bahía de Saint-Michel"

val name2 = "Isla de pascua"
val ubication2 = "Chile"

var monuments = mutableListOf(
    MonumentModel(name, ubication),
    MonumentModel(name2, ubication2)
)