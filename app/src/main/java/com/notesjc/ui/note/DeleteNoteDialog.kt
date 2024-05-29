package com.notesjc.ui.note

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.notesjc.data.note.model.Note


@Composable
fun DeleteNoteDialog(onConfirmButtonClick: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(text = "Delete Note")
            },
            text = {
                Text("Are you sure you want to delete the note?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        onConfirmButtonClick()
                        showDialog = false
                    }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(

                    onClick = {
                        showDialog = false
                    }) {
                    Text("No")
                }
            }
        )
    }
}