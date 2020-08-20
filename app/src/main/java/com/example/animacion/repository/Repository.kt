package com.example.animacion.repository

import androidx.lifecycle.LiveData
import com.example.animacion.Modeldata.Notes
import com.example.animacion.room.NotesDao

class Repository ( private val notesDao: NotesDao ){


    //f solo se usan en view model, ej: UserRepository. readAllData()
    val readAllData: LiveData<List<Notes>> = notesDao.readAllData()

    suspend fun addUser(notes: Notes){
        notesDao.addUser(notes)
    }
}