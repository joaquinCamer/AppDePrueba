package com.example.animacion.ui.notes

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.animacion.Modeldata.Notes
import com.example.animacion.R
import kotlinx.android.synthetic.main.add_note.*
import kotlinx.android.synthetic.main.add_note.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_note, container, false)

        mUserViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        // extraen datos a actualizar
        val firstName = add_note_textview.text.toString()


        if(inputCheck(firstName)){
            // Create User Object
            val notes = Notes(
                0,
                firstName

            )
            // Add Data to Database
            mUserViewModel.addUser(notes) // metodo de insertar los datos
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_navigation_dashboard)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    // se aseguran validaciones de datos vacios
    private fun inputCheck(firstName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) )
    }

}