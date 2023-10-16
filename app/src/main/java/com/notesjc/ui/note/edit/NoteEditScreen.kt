package com.notesjc.ui.note.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.notesjc.ui.note.edit.components.TransparentTextField
import com.notesjc.ui.theme.Purple200

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

        TransparentTextField(
            modifier = Modifier
                .fillMaxWidth(),
            text = titleState.text,
            hint = "Title",
            hintTextSize = 18.sp,
            onValueChange = {
                viewModel.onEvent(EditNoteEvent.EnteredTitle(it))
            },
            textStyle = MaterialTheme.typography.h6
        )

        TransparentTextField(
            modifier = Modifier
                .fillMaxSize(),
            text = contentState.text,
            hint = "Content",
            onValueChange = {
                viewModel.onEvent(EditNoteEvent.EnteredContent(it))
            }
        )

//        LaunchedEffect(key1 = true) {
//            viewModel.eventFlow.collectLatest { event ->
//                when (event) {
//                    EditNoteViewModel.UiEvent.SaveNote -> {
//
//                    }
//                }
//            }
//        }


        DisposableEffect(Unit) {
            onDispose {
                viewModel.onEvent(EditNoteEvent.SaveNote)
            }
        }
    }
}