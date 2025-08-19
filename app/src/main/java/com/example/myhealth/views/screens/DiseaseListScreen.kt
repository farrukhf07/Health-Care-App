package com.example.myhealth.views.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.model.Disease
import com.example.myhealth.model.Medicine
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.DiseaseListVM
import com.example.myhealth.views.components.DiseaseView

@Composable
fun DiseaseListScreen(
    btnBack:()->Unit,
    onDiseaseDetail:(Disease)->Unit
) {
    val viewModel: DiseaseListVM = hiltViewModel()
    val disease by viewModel.disease
    LaunchedEffect(Unit){
        viewModel.fetchDiseaseData()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue)
            .padding(bottom = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "btn back",
                    tint = white,
                    modifier = Modifier.clickable { btnBack() }
                )
                Text(text = "Common Disease List",
                    color = white,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ){
            this.items(disease){
                DiseaseView(name = it.name) {
                    onDiseaseDetail(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDiseaseListScreen() {
    DiseaseListScreen(btnBack = {}, onDiseaseDetail = {})
}