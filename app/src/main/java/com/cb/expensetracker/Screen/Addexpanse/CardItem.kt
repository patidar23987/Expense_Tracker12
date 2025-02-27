package com.cb.expensetracker.Screen.Addexpanse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cb.expensetracker.R
import com.cb.expensetracker.ui.theme.zinc

@Composable
fun CardItem(modifier: Modifier = Modifier
             ,balance :String,income :String,expanse :String) {
    Box(modifier = Modifier) {
        Column(
            modifier = modifier.align(Alignment.CenterEnd)
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(zinc)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            )
            {
                Column {
                    Text(
                        text = "Total Balance",
                        fontSize = 19.sp,
                        color = Color.White)
                    Text(
                        text = balance,
                        fontSize = 26.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)
                }
                Image(
                    painter = painterResource(id = R.drawable.group_8),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.size(40.dp))


            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {

                Column {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.frame_5),
                            contentDescription = null)

                        Text(
                            text = "Income",
                            fontSize = 19.sp,
                            color = Color.White)
                    }
                    Text(
                        text = income,
                        fontSize = 26.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)
                }
                Column {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.frame_7),
                            contentDescription = null)
                        Text(
                            text = "Expense",
                            fontSize = 19.sp,
                            color = Color.White)
                    }
                    Text(
                        text = expanse,
                        fontSize = 26.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}





    @Composable
    @Preview(showBackground = true)
    fun PreviewCardItem() {
        CardItem(
            modifier = Modifier,
            income = "income", balance = "balance", expanse = "expanse"
        )
    }


