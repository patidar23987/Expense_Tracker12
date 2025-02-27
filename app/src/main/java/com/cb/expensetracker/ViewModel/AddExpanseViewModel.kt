package com.cb.expensetracker.ViewModel



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cb.expensetracker.Data.Dao.ExpanseDao
import com.cb.expensetracker.Data.Model.ExpanseDataBase
import com.cb.expensetracker.Data.Model.ExpanseEntity

class AddExpanseViewModel(val dao: ExpanseDao): ViewModel( ) {

    suspend fun addExpanse(expanseEntity: ExpanseEntity):Boolean
    {
        return try{
            dao.insertExpense(expanseEntity)
            true

        }catch ( ex:Throwable){
            false
        }

    }
}
class AddExpanseViewModelFactory (private val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddExpanseViewModel::class.java)) {
            val dao = ExpanseDataBase.getDatabase(context).ExpanseDao()
            @Suppress("UNCHECKED_CAST")
            return AddExpanseViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}