package com.example.jetnotes.navigation

enum class NotesScreens {
    ViewNotesScreen,
    NewNoteScreen;
    companion object {
        fun fromRoute(route: String?): NotesScreens = when (route?.substringBefore("/")){
            ViewNotesScreen.name -> ViewNotesScreen
            NewNoteScreen.name -> NewNoteScreen
            null -> ViewNotesScreen
            else -> throw IllegalArgumentException("Route $route is not valid")
        }
    }
}