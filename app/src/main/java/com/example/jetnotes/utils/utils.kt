package com.example.jetnotes.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val formatter = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return formatter.format(date)
}