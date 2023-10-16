package com.notesjc.ui.note.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.notesjc.ui.theme.Purple200
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NoteEditScreen(navController: NavController, viewModel: EditNoteViewModel = hiltViewModel()) {

    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Purple200)
    ) {

        TextField(
            modifier = Modifier.fillMaxSize(),
            value = contentState.text,
            onValueChange = {
                viewModel.onEvent(EditNoteEvent.EnteredContent(it))
            },
        )

        LaunchedEffect(key1 = true) {
            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    EditNoteViewModel.UiEvent.SaveNote -> {

                    }
                }
            }
        }


        DisposableEffect(Unit) {
            onDispose {
                viewModel.onEvent(EditNoteEvent.SaveNote)
            }
        }

//        DisposableEffect(this){
//            onDispose {
//                viewModel.onEvent(EditNoteEvent.SaveNote)
//            }
//        }
    }
}