package com.example.a7homework1.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.a7homework1.data.local.models.Note


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")// WHERE title = )
    suspend fun getAllNotes(): List<Note>


 /*   @Query("SELECT * FROM notes WHERE title= title")
    suspend fun getAllNotesByTitle(title: String): List<Note>*/


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(notes: List<Note>): List<Long>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}