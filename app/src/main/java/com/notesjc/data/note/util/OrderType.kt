package com.notesjc.data.note.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
