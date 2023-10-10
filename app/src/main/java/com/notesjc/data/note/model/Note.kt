package com.notesjc.data.note.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val description: String,
    val timestamp: Long,
)
