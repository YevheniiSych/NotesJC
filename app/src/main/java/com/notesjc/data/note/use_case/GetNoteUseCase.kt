package com.notesjc.data.note.use_case

import com.notesjc.data.note.model.Note
import com.notesjc.data.note.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}