package com.example.myhealth.views.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.lightPink
import com.example.myhealth.ui.theme.newpurple
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.DiseaseDetailVM

@Composable
fun DiseaseDetailScreen(
    btnBack:()->Unit
) {
    val viewModel: DiseaseDetailVM = hiltViewModel()
    Column(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue),
            ){
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "btn back",
                    tint = white, modifier = Modifier
                        .size(35.dp)
                        .clickable { btnBack() })
                Text(text = "Disease Detail",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = newpurple
            ),
            border = BorderStroke(1.dp, black)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 20.dp)) {
                Text(text = viewModel.disease.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Symptoms",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = viewModel.disease.symptoms)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Preventions",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = viewModel.disease.prevention)
            }
        }
    }
}