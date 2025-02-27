package com.cb.expensetracker.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cb.expensetracker.Screen.Addexpanse.Screen
import com.cb.expensetracker.ui.theme.zincsp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {

        delay(5000L)
        navController.navigate(Screen.SignUp.route)


    }



    Box(modifier = Modifier.fillMaxSize().background(zincsp)){

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "mono",
                fontSize = 36.sp,
                color = White,
                fontFamily = FontFamily.Serif )


        }

    }




}
//@Composable
//@Preview(showBackground = true)
//fun SplashScreenPreview(){
//    SplashScreen(NavController(context = TODO()))
//
//}
