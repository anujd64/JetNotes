package com.example.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnotes.navigation.NotesNavigation
import com.example.jetnotes.screen.NoteViewModel
import com.example.jetnotes.ui.theme.JetNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainContent {

               val noteViewModel: NoteViewModel by viewModels()

               NotesNavigation(noteViewModel = noteViewModel)
//               NewNoteScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
           }
        }
    }
}


@Composable
fun MainContent(content : @Composable () -> Unit){
    JetNotesTheme {
        content()
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNotesTheme {

//        NewNoteScreen(onAddNote = {}, onRemoveNote = {})
    }
}