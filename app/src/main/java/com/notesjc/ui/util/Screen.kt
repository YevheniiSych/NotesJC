package com.notesjc.ui.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen(NotesScreen::class.java.simpleName)
    object NoteEditScreen: Screen(NotesScreen::class.java.simpleName)
}
