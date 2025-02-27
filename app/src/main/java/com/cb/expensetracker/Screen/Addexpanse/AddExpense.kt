package com.cb.expensetracker.Screen.Addexpanse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cb.expensetracker.R
import com.cb.expensetracker.ViewModel.AddExpanseViewModel
import com.cb.expensetracker.ViewModel.AddExpanseViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun AddExpense( navController: NavController){
    val coroutineScope = rememberCoroutineScope()
    val viewModel =
        AddExpanseViewModelFactory(LocalContext.current).create(AddExpanseViewModel::class.java)
    Surface(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_9),
                contentDescription = null)
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 19.dp)
                        .padding(top = 32.dp, start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Column(modifier = Modifier) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null,
                            modifier = Modifier.padding().clickable { navController.navigate(Screen.Home.route) {
                                popUpTo("/home"){
                                    inclusive==true }
                            }
                            }
                        )
                    }
                    Text(
                        text = "Add Expense",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(20.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.group_8),
                        contentDescription = null,)
                }
            }

           DataForm(
               modifier = Modifier
                   .padding(top = 10.dp),
               onAddExpanseClick ={
                   coroutineScope.launch {
                       if(viewModel.addExpanse(it))
                       {
                           navController.popBackStack()
                       }
                   }
                    })

        }
    }
            }
@Composable
@Preview(showBackground = true)
fun AddExpensePreview(){
    AddExpense(rememberNavController())

}
