package com.example.parcialmoviles

import android.app.Application
import com.example.parcialmoviles.data.monuments
import com.example.parcialmoviles.repositories.MonumentRepository

class MonumentReviewerApplication: Application() {
    val monumentRepository: MonumentRepository by lazy {
        MonumentRepository(monuments)
    }
}