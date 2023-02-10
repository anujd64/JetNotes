package com.example.jetnotes.repository

import com.example.jetnotes.data.NoteDatabaseDao
import com.example.jetnotes.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao){

    suspend fun addNote(noteModel: NoteModel) = noteDatabaseDao.insertNote(noteModel)

    suspend fun updateNote(noteModel: NoteModel) = noteDatabaseDao.update(noteModel)

    suspend fun deleteNote(noteModel: NoteModel) = noteDatabaseDao.deleteNote(noteModel)

    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNotes()

    fun getAllNotes(): Flow<List<NoteModel>> = noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO).conflate()

}