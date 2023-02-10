package com.example.jetnotes.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetnotes.screen.AddNewNoteScreen
import com.example.jetnotes.screen.NoteViewModel
import com.example.jetnotes.screen.ViewNotesScreen

@SuppressLint("NewApi")
@Composable
fun NotesNavigation(noteViewModel: NoteViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NotesScreens.ViewNotesScreen.name ){

        composable(NotesScreens.ViewNotesScreen.name){
            ViewNotesScreen(navController = navController,notesViewModel = noteViewModel)
        }

        composable(NotesScreens.NewNoteScreen.name){
            AddNewNoteScreen(navController = navController, notesViewModel = noteViewModel)
        }
    }

}