package com.notesjc.data.note.use_case

import com.notesjc.data.note.model.Note
import com.notesjc.data.note.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}