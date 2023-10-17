package com.notesjc.ui.note.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.notesjc.data.note.model.Note
import com.notesjc.ui.theme.Teal200
import com.notesjc.ui.util.Screen
import kotlin.math.truncate

@Composable
fun NoteView(note: Note, onClick: (noteId: Int?) -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(200.dp)
            .background(Teal200)
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clickable {
                onClick(note.id)
            }
    ) {
        Text(
            text = note.title,
            style = MaterialTheme.typography.h6,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = note.content,
            fontSize = 14.sp
        )
    }
}