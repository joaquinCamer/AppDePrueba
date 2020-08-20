package com.example.animacion.ui.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.animacion.Modeldata.Notes
import com.example.animacion.R
import kotlinx.android.synthetic.main.item_recycler_note.view.*

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    private var userList = emptyList<Notes>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_note, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.textViewNotes.text = currentItem.id.toString()


    }

    fun setData(user: List<Notes>){
        this.userList = user
        notifyDataSetChanged()
    }
}