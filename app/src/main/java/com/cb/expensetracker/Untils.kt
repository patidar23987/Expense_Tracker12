package com.cb.expensetracker

import com.cb.expensetracker.Data.Model.ExpanseEntity
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils
{
        fun formatDateToHumanReadableForm(dateInMillis: Long): String {
            val dateFormatter = SimpleDateFormat(
                "dd/MM/YYYY",
                Locale.getDefault())
            return dateFormatter.format(dateInMillis)
        }

    fun formatDateForChart(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat(
            "dd/MMM", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }
    fun formatCurrency(amount: Double,locale: Locale=Locale.US): String {
        val currencyFormatter = NumberFormat.getCurrencyInstance(locale)
        return currencyFormatter.format(amount)
    }
    fun formatDateMonthYear(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat("MMM DD,YYYY", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }
    fun formatDateMonth(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat("DD/MMM", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun formatToDecimalValue(d: Double): String {
        return String.format("%.2f", d)
    }

    fun formatStringDateToMonthDayYear(date: String): String {
        val millis = getMillisFromDate(date)
        return formatDateMonthYear(millis)
    }

    fun getMillisFromDate(date: String): Long {
        return getMilliFromDate(date)
    }

    fun getMilliFromDate(dateFormat: String?): Long {
        var date = Date()
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        try {
            date = formatter.parse(dateFormat)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        println("Today is $date")
        return date.time
    }

    fun getItemIcon(item: ExpanseEntity): Int {
        return if (item.tittle == "Paypal") {
            R.drawable.ic_paypal
        } else if (item.tittle == "Netflix") {
            R.drawable.ic_netflix
        } else if (item.tittle == "Starbucks") {
            R.drawable.ic_starbucks
        } else {
            R.drawable.ic_upwork
        }
    }

}