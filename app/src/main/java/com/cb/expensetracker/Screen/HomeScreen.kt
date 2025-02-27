package com.cb.expensetracker.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cb.expensetracker.R
import com.cb.expensetracker.Screen.Addexpanse.CardItem
import com.cb.expensetracker.Screen.Addexpanse.Screen
import com.cb.expensetracker.Screen.Addexpanse.TransactionList
import com.cb.expensetracker.ViewModel.HomeViewModel
import com.cb.expensetracker.ViewModel.HomeViewModelFactory

@Composable
fun HomeScreen (navController: NavHostController) {
    val viewModel: HomeViewModel =
        HomeViewModelFactory(LocalContext.current).create(HomeViewModel::class.java)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddExpense.route)}

            ) {
                Icon(Icons.Default.Add, "Add")
            }
        }
    ) { paddingValues ->


        Box(modifier = Modifier
            .fillMaxSize()
            .padding()) {
            // val (namRow,list,card,topBar,add) = createRefs

            Image(
                painter = painterResource(id = R.drawable.rectangle_9),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Column {


                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp, start = 20.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column {
                        Text(
                            text = "Good Afternoon",
                            fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White
                        )
                        Text(
                            text = "CodeWithFX",
                            fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.baseline_notifications_none_24),
                        contentDescription = null,
                    )
                }

                val state = viewModel.expanses.collectAsState(initial = emptyList())
                val expanse = viewModel.getTotalExpanse(state.value)
                val income = viewModel.getTotalIncome(state.value)
                val balance = viewModel.getBalance(state.value)
                CardItem(
                    modifier = Modifier
                        .padding(top = 45.dp),
                    balance = balance,
                    income = income,
                    expanse = expanse
                )
                TransactionList(
                    modifier = Modifier
                        .padding(),
                    list = state.value,
                    onSeeAllClicked = {},
                    getItemIcon = {
                        viewModel.getItemIcon(it)
                    }
                )

            }
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun PreviewHomeScreen(){
//    HomeScreen(rememberNavController())
//
//}
