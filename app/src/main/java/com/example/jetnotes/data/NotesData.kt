package com.example.jetnotes.data

import com.example.jetnotes.model.NoteModel

class NotesDataSource {
    fun loadNotes(): List<NoteModel>{
        return listOf(
            NoteModel(title = "A good day", description = "We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake"),
            NoteModel(title = "Android Compose", description = "Working on Android Compose course today We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lak"),
            NoteModel(title = "Keep at it...", description = "Sometimes things just happen We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lak"),
            NoteModel(title = "A movie day", description = "Watching a movie with family today We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lak"),
            NoteModel(title = "A Sunday", description = "Watching a movie with family today We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lake We went on a vacation by the lak")
        )
    }
}