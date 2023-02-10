package com.example.jetnotes.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.jetnotes.R
import com.example.jetnotes.components.NoteRow
import com.example.jetnotes.data.NotesDataSource
import com.example.jetnotes.model.NoteModel
import com.example.jetnotes.navigation.NotesScreens


@Composable
fun ViewNotesScreen(navController: NavController,notesViewModel: NoteViewModel) {

    val notes = notesViewModel.noteList.collectAsState().value

    Column() {

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    modifier = Modifier.clickable { navController.navigate(route = NotesScreens.NewNoteScreen.name) },
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add"
                )
            },
            backgroundColor = Color(0xFF1B99FE)
        )

        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note, onDeleteClicked = {notesViewModel.removeNote(it) })
            }
        }

    }


}
