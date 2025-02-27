package com.cb.expensetracker.Screen.Addexpanse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cb.expensetracker.Data.Model.ExpanseEntity
import com.cb.expensetracker.ViewModel.HomeViewModel

@Composable
fun TransactionList(
    modifier: Modifier,
    list: List<ExpanseEntity>,
    title: String = "recent Transaction",
    getItemIcon: (ExpanseEntity) -> Int,
    onSeeAllClicked: () -> Unit
) {

    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Recent Trancations", fontSize = 20.sp)
                Text(
                    text = "Sell All", fontSize = 16.sp, color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
          Spacer(modifier=Modifier.size(42.dp))
            }
        }

        items(list) { item ->
            TransactionItem(
                tittle = item.tittle,
                amount = item.amount.toString(),
                icon = getItemIcon(item),
                date = item.date.toString(),
                color = if (item.type == "income") Color.Green else Color.Red,

            )

        }
    }
}
