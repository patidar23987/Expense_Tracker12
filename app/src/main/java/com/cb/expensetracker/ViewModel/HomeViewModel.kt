package com.cb.expensetracker.ViewModel

import android.content.Context
import android.util.Log
import androidx.constraintlayout.core.motion.utils.Utils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.cb.expensetracker.Data.Dao.ExpanseDao
import com.cb.expensetracker.Data.Model.ExpanseDataBase
import com.cb.expensetracker.Data.Model.ExpanseEntity
import com.cb.expensetracker.R

class HomeViewModel(dao: ExpanseDao) :ViewModel() {
    val expanses = dao.getALLExpenses()


    fun getBalance(list: List<ExpanseEntity>): String {
        var total = 0.0
        list.forEach { expanse->
            if (expanse.type == "Income"){
                total += expanse.amount.toDouble()
            } else {
                total -= expanse.amount.toDouble()

            }

        }
        return "$ ${total}"
    }

    fun getTotalExpanse(list: List<ExpanseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Expanse") {
                total += it.amount.toDouble()
            }

        }
        return "$ ${total}"
    }


    fun getTotalIncome(list: List<ExpanseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Income") {
                total += it.amount.toDouble()
            }
        }
        return "$ ${total}"
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

class HomeViewModelFactory(private val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpanseDataBase.getDatabase(context).ExpanseDao()
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao)as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}









