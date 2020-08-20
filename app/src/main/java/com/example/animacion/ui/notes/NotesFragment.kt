package com.example.animacion.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animacion.Modeldata.Notes

import com.example.animacion.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Recyclerview
        val adapter = NotesAdapter()
        val recyclerView = view.recyclerviewNote
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        notesViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_dashboard_to_addFragment)
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }






}