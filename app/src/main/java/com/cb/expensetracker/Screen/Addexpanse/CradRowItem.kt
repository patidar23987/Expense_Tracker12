package com.cb.expensetracker.Screen.Addexpanse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardRowItem(
    modifier: Modifier,
    tittle: String,
    image: Int,
    amount: String
) {
    Column(modifier = Modifier) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = tittle,
                fontSize = 19.sp,
                color = Color.White
            )
        }

        Text(
            text = amount,
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

}
//
//@Composable
//@Preview(showBackground = true)
//fun PreviewCradRowItem(){
//    CardRowItem(modifier  = Modifier,"visual ",  0, 2323.toString())
//}