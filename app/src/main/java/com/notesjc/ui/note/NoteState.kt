package com.notesjc.ui.note

import com.notesjc.data.note.model.Note
import com.notesjc.data.note.util.NoteOrder
import com.notesjc.data.note.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
