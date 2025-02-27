package com.cb.expensetracker.Screen.Addexpanse

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cb.expensetracker.Data.Model.ExpanseEntity
import com.cb.expensetracker.Utils
import com.cb.expensetracker.ui.theme.zinc

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataForm(modifier: Modifier, onAddExpanseClick: (model:ExpanseEntity) -> Unit){
    val name = remember{
        mutableStateOf("")
    }
    val amount = remember{
        mutableStateOf("")
    }
    val date = remember{
        mutableLongStateOf(0L)
    }
    val dateDialogVisibility = remember {
        mutableStateOf(false)
    }
    val category = remember {
        mutableStateOf("")
    }
    val type = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(top = 150.dp)
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .height(600.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Text(text = "Name",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold)

        OutlinedTextField(value = name.value,
            onValueChange = { name.value = it
        },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),)
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Amount", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(value = amount.value,
            onValueChange = {
            amount.value = it
        },
            modifier = Modifier.fillMaxWidth() ,
            shape = RoundedCornerShape(12.dp),)
        Spacer(modifier = Modifier.size(8.dp))

        // date

            Text(text = "Date", fontSize = 14.sp,
                fontWeight = FontWeight.Bold)
      OutlinedTextField(
          value = if(date.longValue == 0L )""
          else Utils.formatDateToHumanReadableForm( date.longValue),
            onValueChange = {},
          shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .clickable { dateDialogVisibility.value = true },
            enabled = false

        )
        Spacer(modifier = Modifier.size(8.dp))

        // dropdown
        Text(text = "Category", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(8.dp))
        ExpanseDropDown(listOf("Netflix","Paypal","StarBuck","UpWork","Salary"),
            onItemSelected = {
                category.value = it
                })
        Spacer(modifier = Modifier
            .size(8.dp)
        )

        Text(text = "Type",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(8.dp))


        ExpanseDropDown(listOf("Income","Expanse"),
            onItemSelected = {
                type.value = it
            })




        // type



 Spacer(modifier = Modifier.size(28.dp))
        Button(onClick = {
            val model = ExpanseEntity(
               id = null,
                tittle = name.value,
               amount =  (amount.value.toDoubleOrNull() ?: 0.0).toString(),
             date = Utils.formatDateToHumanReadableForm(date.longValue),
                category = category.value,
                type = type.value
            )
            onAddExpanseClick(model)
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = zinc,
                contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp))) {
            Text(text = "Add Expense",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
        }
    }







    if (dateDialogVisibility.value){
        ExpanseDatePickerDialog(onDateSelected = {
            date.value = it
            dateDialogVisibility.value = false
        },
            onDismiss = {
                dateDialogVisibility.value = false })
    }
}



@Composable
fun TitleComponent (title: String) {
    Text(
        text = title.uppercase(),
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        color = Color.DarkGray
    )
    Spacer(modifier = Modifier.size(10.dp))
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpanseDatePickerDialog(
    onDateSelected:(date : Long)->Unit,
    onDismiss:()-> Unit)
{
    val dataPickerState = rememberDatePickerState()
    val selectedDate = dataPickerState.selectedDateMillis ?: 0L
    DatePickerDialog(onDismissRequest = { onDismiss() }, confirmButton = {
        TextButton(onClick = { onDateSelected(selectedDate) }) {
            Text(text = "Confirm")
        }
    },
        dismissButton = {
            TextButton(onClick = { onDateSelected(selectedDate) }) {
                Text(text = "Cancel")
            }
        }) {
        DatePicker(state = dataPickerState)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun ExpanseDropDown(listOfItems: List<String>, onItemSelected: (item : String) -> Unit) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val SelectedItem = remember {
        mutableStateOf(listOfItems[0])
    }
    ExposedDropdownMenuBox(expanded = expanded.value, onExpandedChange = {
        expanded.value = it}) {
        TextField(value =SelectedItem.value, onValueChange ={},
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value)
            }
        )
        ExposedDropdownMenu(expanded = expanded.value, onDismissRequest = {}) {
            listOfItems.forEach{
                DropdownMenuItem(text = { Text(text = it) },
                    onClick = {SelectedItem.value = it
                        onItemSelected(SelectedItem.value)
                        expanded.value = false
                    })
            }
        }

    }
}

//@Composable
//@Preview
//fun PreviewDataForm(){
//    DataForm(
//        modifier = Modifier, onAddExpanseClick(ExpanseEntity)
//
//
//    )
//}
