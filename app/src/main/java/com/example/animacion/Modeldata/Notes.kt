package com.example.animacion.Modeldata

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
    @Entity(tableName = "notes_table")
    data class Notes(
@PrimaryKey(autoGenerate = true)
val id: Int,
val firstName: String

): Parcelable


