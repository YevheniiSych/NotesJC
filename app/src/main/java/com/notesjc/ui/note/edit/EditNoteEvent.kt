package com.notesjc.ui.note.edit

sealed class EditNoteEvent {
    data class EnteredTitle(val value: String): EditNoteEvent()
    data class EnteredContent(val value: String): EditNoteEvent()
    object SaveNote: EditNoteEvent()
}