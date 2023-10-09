package com.notesjc.ui.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes")
    object NoteEditScreen: Screen("note_edit")
}
