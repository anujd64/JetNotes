package com.example.jetnotes.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnotes.data.NotesDataSource
import com.example.jetnotes.model.NoteModel
import com.example.jetnotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    //    private var noteList = mutableStateListOf<NoteModel>()
    private var _noteList = MutableStateFlow<List<NoteModel>>(emptyList())

    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect {
                    listOfNotes ->
                if(listOfNotes.isNullOrEmpty()){
                    Log.d("Empty", ": Empty List")
                }else{
                   _noteList.value = listOfNotes
                }
            }
        }
//        noteList.addAll(NotesDataSource().loadNotes())
    }


    fun addNote(note: NoteModel) = viewModelScope.launch { repository.addNote(note) }

    fun removeNote(note: NoteModel) = viewModelScope.launch { repository.deleteNote(note) }

    fun updateNote(note: NoteModel) = viewModelScope.launch { repository.updateNote(note) }
}