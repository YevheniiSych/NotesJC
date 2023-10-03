package com.notesjc.ui.note.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notesjc.model.Note
import com.notesjc.ui.theme.Purple200

@Composable
fun NotesScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Purple200)
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ) {
        NotesLazyList(
            items = createItems()
        )
    }
}

fun createItems(): List<Note> {
    return listOf(
        Note("1", "Hello World", "Creative dev"),
        Note("2", "Hello World", "Creative dev"),
    )
}

@Composable
fun NotesLazyList(items: List<Note>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { note ->
            NoteView(note = note)
        }
    }
}

