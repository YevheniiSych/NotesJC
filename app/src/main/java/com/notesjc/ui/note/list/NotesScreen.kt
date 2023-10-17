package com.notesjc.ui.note.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.notesjc.data.note.model.Note
import com.notesjc.ui.note.list.components.NoteView
import com.notesjc.ui.theme.Purple200
import com.notesjc.ui.util.Screen

@Composable
fun NotesScreen(navController: NavController, viewModel: NotesViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Purple200)
            .padding(start = 10.dp, end = 10.dp)
    ) {

//        var isExpanded by remember { mutableStateOf(true) }
//        DropdownMenu(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp),
//            expanded = isExpanded,
//            onDismissRequest = {
//            isExpanded = false
//        }) {
//            DropdownMenuItem(onClick = {
//                isExpanded = false
//            }) {
//                Text(text = "Date asc")
//            }
//            DropdownMenuItem(onClick = {
//                isExpanded = false
//            }) {
//                Text(text = "Date desc")
//            }
//        }

        Box(
            Modifier
                .fillMaxSize()
        ) {
            NotesLazyList(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                items = viewModel.state.value.notes,
                navController = navController,
            )

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                onClick = { navController.navigate(Screen.NoteEditScreen.route) },
                backgroundColor = Color.Red,
            ) {
                Icon(Icons.Filled.Add, "Add note button")
            }
        }
    }
}

@Composable
fun NotesLazyList(modifier: Modifier, items: List<Note>, navController: NavController) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { note ->
            NoteView(
                note = note,
                onClick = {
                    navController.navigate(Screen.NoteEditScreen.route + "?noteId=${note.id}")
                }
            )
        }
    }
}

