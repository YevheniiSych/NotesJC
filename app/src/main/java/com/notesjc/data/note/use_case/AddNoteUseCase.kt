package com.notesjc.data.note.use_case

import com.notesjc.data.note.model.InvalidNoteException
import com.notesjc.data.note.model.Note
import com.notesjc.data.note.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
//        if (note.title.isBlank()) {
//            throw InvalidNoteException("The title of the note can't be empty.")
//        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}