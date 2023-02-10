package com.example.jetnotes.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.example.jetnotes.model.NoteModel
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes_tbl")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: NoteModel)

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAllNotes()


    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(noteModel: NoteModel)
}
