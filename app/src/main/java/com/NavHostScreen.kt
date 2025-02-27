package com

import android.annotation.SuppressLint
import androidx.collection.emptyLongSet
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cb.expensetracker.R
import com.cb.expensetracker.Screen.Addexpanse.AddExpense
import com.cb.expensetracker.Screen.Addexpanse.Screen
import com.cb.expensetracker.Screen.HomeScreen
import com.cb.expensetracker.Screen.LogInScreen
import com.cb.expensetracker.Screen.SignUpScreen
import com.cb.expensetracker.Screen.SplashScreen
import com.cb.expensetracker.Screen.StatsScreen
import com.cb.expensetracker.ViewModel.AuthViewModel
import com.cb.expensetracker.ui.theme.zinc
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavHostScreen(){
    val navController = rememberNavController ()
     var bottomBarVisibility by remember {
         mutableStateOf(true)
     }

    Scaffold (bottomBar = {
        AnimatedVisibility(visible = bottomBarVisibility) {
            NavigationBottomBar(navController = navController,
            items = listOf(
                NavItem(route = "/home", icon = R.drawable.home) ,
                NavItem(route = "/stats", icon = R.drawable.chart)
            )) }

    }){

        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route ,
            modifier = Modifier.padding(it))
        {

            composable(Screen.Splash.route){
                LaunchedEffect(Unit) {
                    bottomBarVisibility = false
                    delay(5000)

                }

                SplashScreen(navController)

            }
            composable(Screen.SignUp.route){
                bottomBarVisibility = false
                SignUpScreen(Modifier,navController,AuthViewModel())
            }
            composable(Screen.LogIn.route){
                bottomBarVisibility = false
                LogInScreen(Modifier,navController,AuthViewModel())
            }
            composable(Screen.Home.route){
                bottomBarVisibility = true
                HomeScreen(navController)
            }
            composable(Screen.AddExpense.route){
                bottomBarVisibility = false
                AddExpense(navController )
            }
            composable(Screen.Statcs.route){
                bottomBarVisibility = true
                StatsScreen(navController)
            }
        }

    }


    }



data class NavItem(
    val route : String,
     val icon : Int
)



@Composable
fun NavigationBottomBar(
    navController: NavController,
    items :List<NavItem>
){
// bottom navigation bar
    val NavBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = NavBackStackEntry.value?.destination?.route

BottomAppBar {
    items.forEach{item->
        NavigationBarItem(
            selected = currentRoute == item.route,
            onClick = {
                if(item.route=="/home") {
                    navController.navigate("home"){
                        popUpTo("home"){inclusive=true}
                    }
                }
                else {
                    navController.navigate("statcs"){
                        popUpTo(navController.graph.startDestinationId)
                        {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }

                }


                },
            icon ={
                Icon(painter = painterResource(id = item.icon), contentDescription = null)
            },
            alwaysShowLabel = false,
         colors = NavigationBarItemColors(
             selectedTextColor = zinc,
            selectedIconColor = zinc,
             unselectedTextColor = Color.Gray,
             unselectedIconColor = Color.Gray,
             selectedIndicatorColor = zinc ,
             disabledIconColor = Color.LightGray,
             disabledTextColor = Color.LightGray,
         )
          )
    }
  }
}