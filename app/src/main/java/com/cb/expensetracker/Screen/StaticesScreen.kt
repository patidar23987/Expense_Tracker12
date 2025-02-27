package com.cb.expensetracker.Screen

import android.view.LayoutInflater
import androidx.collection.scatterSetOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.cb.expensetracker.R
import com.cb.expensetracker.Screen.Addexpanse.Screen
import com.cb.expensetracker.Screen.Addexpanse.TransactionList
import com.cb.expensetracker.Utils
import com.cb.expensetracker.ViewModel.StatcsViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.cb.expensetracker.ViewModel.StatcsViewModelFactory


//
//@Composable
//fun StatcsScreen(navController: NavController, viewModel: StatcsViewModel) {
//
//    Box {
//        Scaffold(topBar = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 23.dp),
//
//                )
//            {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
//                        contentDescription = null,
//                        colorFilter = ColorFilter.tint(Color.Black)
//                    )
//                    Text(
//                        text = "Statices",
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                        modifier = Modifier.padding(20.dp)
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.group_8),
//                        contentDescription = null,
//                        colorFilter = ColorFilter.tint(Color.Black)
//                    )
//                }
//
//
//
//
//                    val viewmodel =
//                        StatcsViewModelFactory(navController.context).create(StatcsViewModel::class.java)
//                    val dataState = viewmodel.entries.collectAsState(emptyList())
//
//
//                    Column(modifier = Modifier.padding()) {
//                        //val entries = viewModel.getEntriesForChart(dataState.value)
//                        val topExpense = viewModel.topEntries.collectAsState(initial = emptyList())
//                        val entries = viewModel.getEntriesForChart(dataState.value)
//                        LineChart(entries = entries)
//                        Spacer(modifier = Modifier.height(16.dp))
//                        TransactionList(
//                            Modifier, list = topExpense.value, "Top Spending", onSeeAllClicked = {},
//                            viewModel = TODO()
//                        )
//                    }
//                }
//
//
//                @Composable
//                fun LineChart(entries: List<Entry>) {
//                    val context = LocalContext.current
//                    AndroidView(
//                        factory = {
//                            val view =
//                                LayoutInflater.from(context).inflate(R.layout.chart_line, null)
//                            view
//                        }, modifier = Modifier
//                            .fillMaxWidth()
//                            .height(250.dp)
//                    )
//                    { view ->
//                        val lineChart = view.findViewById<LineChart>(R.id.lineChart)
//
//                        val dataSet = LineDataSet(entries, "Expanse").apply{
//                            color = android.graphics.Color.parseColor("FF2F7E79")
//                            valueTextColor = android.graphics.Color.BLACK
//                            lineWidth = 3f
//                            axisDependency = YAxis.AxisDependency.RIGHT
//                            setDrawFilled(true)
//                            mode = LineDataSet.Mode.CUBIC_BEZIER
//                            valueTextSize = 12f
//                            valueTextColor = android.graphics.Color.parseColor("FF2F7E79")
//                            val drawable =
//                                ContextCompat.getDrawable(context, R.drawable.chart_gradient)
//                            drawable?.let {
//                                fillDrawable = it
//                            }
//                        }
//
//                        lineChart.xAxis.valueFormatter =
//                            object : ValueFormatter() {
//                                override fun getFormattedValue(value: Float): String {
//                                    return Utils.formatDateForChart(value.toLong())
//                                }
//                            }
//                        lineChart.data = LineData(dataSet)
//                        lineChart.axisLeft.isEnabled = false
//                        lineChart.axisRight.isEnabled = false
//                        lineChart.axisRight.setDrawGridLines(false)
//                        lineChart.axisLeft.setDrawGridLines(false)
//                        lineChart.xAxis.setDrawGridLines(false)
//                        lineChart.xAxis.setDrawAxisLine(false)
//                        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
//                        lineChart.invalidate()
//                    }
//                }
//


@Composable
fun StatsScreen(navController: NavController ) {
    Scaffold(topBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.CenterStart
                ).clickable {
                    navController.navigate("home"){
                        popUpTo("home"){inclusive=true}
                    }
                },
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.outline)
            )
            Text(
                text = "Statistics",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )



        }
    }) {
        val viewModel = remember {
            StatcsViewModelFactory(navController.context).create(StatcsViewModel::class.java)
        }
        val dataState = viewModel.entries.collectAsState(emptyList())
       val topExpense = viewModel.topEntries.collectAsState(initial = emptyList())
        Column(modifier = Modifier.padding(it)) {
            val entries = viewModel.getEntriesForChart(dataState.value)
            LineChart(entries = entries)
            Spacer(modifier = Modifier.height(26.dp))
            TransactionList(Modifier,list = topExpense.value, "Top Spending", onSeeAllClicked = {},
                getItemIcon = { expense ->
                    viewModel.getItemIcon(expense)
                }
            )
        }
    }
}

@Composable
fun LineChart(entries: List<Entry>) {
    println("entries ye hai - $entries")
    val context = LocalContext.current
    AndroidView(
        factory = {
            val view = LayoutInflater.from(context).inflate(R.layout.chart_line, null)
            view
        }, modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) { view ->
        val lineChart = view.findViewById<LineChart>(R.id.lineChart)
        val dataSet = LineDataSet(entries, "Expenses").apply {
            color = android.graphics.Color.parseColor("#FF2F7E79")
            valueTextColor = android.graphics.Color.BLACK
            lineWidth = 3f
            axisDependency = YAxis.AxisDependency.RIGHT
            setDrawFilled(true)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            valueTextSize = 12f
            valueTextColor = android.graphics.Color.parseColor("#FF2F7E79")
            val drawable = ContextCompat.getDrawable(context, R.drawable.chart_gradient)
            drawable?.let {
                fillDrawable = it
            }

        }

        lineChart.xAxis.valueFormatter =
            object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    return Utils.formatDateForChart(value.toLong())
                }
            }
        lineChart.data = LineData(dataSet)
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false
        lineChart.axisRight.setDrawGridLines(false)
        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.xAxis.setDrawAxisLine(false)
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.invalidate()
    }
}

//
//@Composable
//fun DropDownDemo(navController: NavController) {
//
//    var Expanded = remember {
//        mutableStateOf(false)
//    }
//
//    Box {
//        IconButton(onClick = { Expanded = true }) {
//            Icon(Icons.Default.MoreVert, contentDescription = null)
//        }
//        DropdownMenu(
//            Expanded = Expanded,
//            onDismissRequest = { Expanded = false })
//        {
//            DropdownMenuItem(
//                text = { Text(text = "Signout") },
//                onClick = {
//                    navController.navigate(Screen.LogIn.route)
//                },
//
//                )
//        }
//    }
//}
//
//
//
//
//
//
//




















