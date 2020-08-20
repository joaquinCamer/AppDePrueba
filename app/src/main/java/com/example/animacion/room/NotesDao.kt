package com.example.animacion.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.animacion.Modeldata.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: Notes)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Notes>>

}