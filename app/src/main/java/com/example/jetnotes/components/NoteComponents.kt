package com.example.jetnotes.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnotes.data.NotesDataSource
import com.example.jetnotes.model.NoteModel
import com.example.jetnotes.utils.formatDate
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()

        }),
        modifier = modifier
    )
}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        modifier = modifier,
        enabled = enabled,
    )
    { Text(text) }
}

//@SuppressLint("NewApi")
@Composable
fun NoteRow(note: NoteModel,
            onDeleteClicked: (note: NoteModel) -> Unit) {
    Surface(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp))
                .fillMaxWidth()
                ,
            color = Color.LightGray
        ) {

            Column(modifier = Modifier.padding(15.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = note.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                    Icon(modifier = Modifier.clickable { onDeleteClicked(note) }, imageVector = Icons.Rounded.Delete, contentDescription = "Delete")
                }
                Text(modifier = Modifier.padding(all = 5.dp), text = note.description, style = MaterialTheme.typography.body2, fontSize = 14.sp)
                Text(
                    text = formatDate(note.entryDate.time),

//                    text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                    style = MaterialTheme.typography.subtitle2 , fontWeight = FontWeight.Light)
            }
        }

}

