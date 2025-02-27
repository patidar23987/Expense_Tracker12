package com.cb.expensetracker.Data.Model


data class ExpenseSummary(
    val type: String,
    val date: String,
    val total_amount: Double
)