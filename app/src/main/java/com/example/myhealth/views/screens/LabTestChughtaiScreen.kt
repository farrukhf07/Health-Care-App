package com.example.myhealth.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.model.LabTest
import com.example.myhealth.model.Laboratory
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.LabTestChughtaiVM
import com.example.myhealth.views.components.LabTestView

@Composable
fun LabTestChughtaiScreen(
    onTestDetail:(LabTest)->Unit,
    btnBack:()->Unit
) {
    val viewModel: LabTestChughtaiVM = hiltViewModel()
    val tests by viewModel.testChughtai

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryBlue)
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",
                    modifier = Modifier.size(30.dp).clickable { btnBack() },
                    tint = white)
                Text(
                    text = "Chughtai Lab Tests",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Explore All Tests",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            this.items(tests){
                LabTestView(name = it.name, price = it.price.toString(), laboratory = it.laboratory){
                    onTestDetail(it)
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowLabTestList() {
//    LabTestChughtaiScreen(onTestDetail = {})
//}