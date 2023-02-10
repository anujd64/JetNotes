package com.example.jetnotes.screen

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetnotes.R
import com.example.jetnotes.components.NoteButton
import com.example.jetnotes.components.NoteInputTextField
import com.example.jetnotes.model.NoteModel


//@SuppressLint("NewApi")
//@Composable
//fun NewNoteScreen(
//    navController: NavController,
//    notesViewModel: NoteViewModel,
//){
//    AddNewNote(navController = navController, onAddNote = { notesViewModel.addNote(it) } )
//}

@SuppressLint("NewApi")
@Composable
fun AddNewNoteScreen(
    navController: NavController,
    notesViewModel: NoteViewModel,
){

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(modifier = Modifier.clickable { navController.popBackStack() }, imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back")
            },
            backgroundColor = Color(0xFF1B99FE)
        )



        //Content
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            NoteInputTextField(
                modifier = Modifier.padding(vertical = 8.dp),
                text = title,
                label = "Title" ,
                onTextChange = {
                    if(it.all { char -> char.isLetter() || char.isWhitespace()  }) title = it
                }
            )

            NoteInputTextField(
                modifier = Modifier.padding(bottom = 8.dp),
                text = description,
                label = "Description" ,
                onTextChange = {
                    if(it.all { char -> char.isLetter() || char.isWhitespace()  }) description = it
                }
            )
            
            NoteButton(modifier = Modifier
                .height(35.dp)
                .fillMaxWidth()
                .padding(horizontal = 30.dp), text = "Add", onClick = {
                if(title.isNotEmpty() && description.isNotEmpty()){
                    notesViewModel.addNote(note= NoteModel(title =title, description = description))
                    Toast.makeText(context,"Added", Toast.LENGTH_LONG).show()

                    title = ""
                    description = ""
                }
            })

        }

    }
}



