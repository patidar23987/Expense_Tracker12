package com.cb.expensetracker.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "extanse_table")

data class ExpanseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val amount: String,
    val tittle: String,
    val category: String,
    val date: String,
    val type: String

)
