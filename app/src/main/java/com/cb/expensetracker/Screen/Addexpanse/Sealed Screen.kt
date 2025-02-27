package com.cb.expensetracker.Screen.Addexpanse

sealed class Screen(val route: String) {
    object LogIn : Screen("login")
    object  SignUp: Screen("signup")
    object Splash : Screen("splash")
    object Home : Screen("home")
    object AddExpense : Screen("addexpanse")
    object Statcs : Screen("statcs")// Match case exactly
}