package com.notesjc.ui.note.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.notesjc.ui.theme.Purple200

@Composable
fun NoteEditScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Purple200)
    ) {
        var text by remember { mutableStateOf("Write your notes") }

        TextField(
            modifier = Modifier.fillMaxSize(),
            value = text,
            onValueChange = { text = it },
        )
    }
}