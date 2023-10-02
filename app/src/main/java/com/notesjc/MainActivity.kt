package com.notesjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notesjc.model.Note
import com.notesjc.ui.theme.NotesJCTheme
import com.notesjc.ui.theme.Purple200
import com.notesjc.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NotesLazyList(
                        items = createItems(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(color = Purple200)
                            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                    )
                }
            }
        }
    }
}

fun createItems(): List<Note> {
    return listOf(
        Note("1", "Hello World", "Creative dev"),
        Note("2", "Hello World", "Creative dev")
    )
}

@Composable
fun NotesLazyList(items: List<Note>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(items) { note ->
            NoteView(note = note)
        }
    }
}

@Composable
fun NoteView(note: Note) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .background(Teal200)
    ) {
        Text(text = note.title)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = note.description)
    }
}