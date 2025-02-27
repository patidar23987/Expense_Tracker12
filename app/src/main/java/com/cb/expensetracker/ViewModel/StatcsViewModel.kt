package com.cb.expensetracker.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cb.expensetracker.Data.Dao.ExpanseDao
import com.cb.expensetracker.Data.Model.ExpanseDataBase
import com.cb.expensetracker.Data.Model.ExpanseEntity
import com.cb.expensetracker.Data.Model.ExpenseSummary
import com.cb.expensetracker.R
import com.cb.expensetracker.Utils
import com.github.mikephil.charting.data.Entry
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatcsViewModel @Inject constructor(dao: ExpanseDao):ViewModel() {
    val topEntries = dao.getTopExpenses()
    val entries = dao.getAllExpanseByDate()


    fun getEntriesForChart(entries:List<ExpenseSummary>):List<Entry> {
        val list = mutableListOf<Entry>()
        for (entry in entries) {
            val formattedDate = Utils.getMilliFromDate(entry.date)
            list.add(Entry(formattedDate.toFloat(), entry.total_amount.toFloat()))
        }
          return list

    }

    fun getItemIcon(item: ExpanseEntity): Int {
        if (item.category == "paypal") {
            return R.drawable.ic_paypal
        } else if (item.category == "Netflix") {
            return R.drawable.ic_netflix
        } else if (item.category == "starbucks") {
            return R.drawable.ic_starbucks
        }
        return R.drawable.ic_upwork
    }


}



class StatcsViewModelFactory(private val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatcsViewModel::class.java)) {
            val dao = ExpanseDataBase.getDatabase(context).ExpanseDao()
            @Suppress("UNCHECKED_CAST")
            return StatcsViewModel(dao)as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }


}


