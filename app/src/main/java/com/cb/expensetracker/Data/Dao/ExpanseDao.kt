package com.cb.expensetracker.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cb.expensetracker.Data.Model.ExpanseEntity
import com.cb.expensetracker.Data.Model.ExpenseSummary
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpanseDao {



    @Query("SElECT * FROM EXTANSE_TABLE")
    fun getALLExpenses(): Flow<List<ExpanseEntity>>

    @Query("SELECT * FROM EXTANSE_TABLE WHERE type = 'Expanse' ORDER BY amount DESC LIMIT 5")
    fun getTopExpenses(): Flow<List<ExpanseEntity>>

   @Query("SElECT type,date,SUM(amount) AS total_amount FROM EXTANSE_TABLE where type =:type GROUP BY type,date ORDER BY date ")
    fun getAllExpanseByDate(type:  String = "Expanse"): Flow<List<ExpenseSummary>>

@Insert
suspend fun insertExpense(expanseEntity: ExpanseEntity)

@Delete
suspend fun deleteExpense(expanseEntity: ExpanseEntity)

@Update
suspend fun updateExpanse(expanseEntity: ExpanseEntity)

}