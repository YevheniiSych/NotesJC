package com.notesjc.ui.note.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.notesjc.ui.note.list.NotesLazyList
import com.notesjc.ui.note.list.createItems
import com.notesjc.ui.theme.Purple200

@Composable
fun NoteEditScreen(navController: NavController) {
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