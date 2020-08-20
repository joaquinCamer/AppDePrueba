package com.example.animacion.ui.notes

import android.app.Application
import androidx.lifecycle.*
import com.example.animacion.Modeldata.Notes
import com.example.animacion.repository.Repository
import com.example.animacion.room.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (application: Application): AndroidViewModel(application) {

    // se inicializa siempre f de getData y el respositorio
    val readAllData: LiveData<List<Notes>>
    private val repository: Repository

    init { // inicializa la conexion de la base de datos con getdata del repositorio
        val userDao = NoteDatabase.getDatabase(
            application
        ).userDao()
        repository = Repository(userDao)
        readAllData = repository.readAllData
    }
    //-------funciones del repositorio con coroutines-----------------------------------------------------------
    fun addUser(user: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }



}