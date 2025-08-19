package com.example.myhealth.views.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.DoctorProfileVM
import com.example.myhealth.views.components.DoctorView

@Composable
fun DoctorProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val viewModel: DoctorProfileVM = hiltViewModel()

//        LaunchedEffect(Unit){
//            viewModel.fetchDocImage()
//        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryBlue)
                .padding(bottom = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Doctor's Information",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = white,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                DoctorView(
                    name = viewModel.doctor.value.full_name?:"",
                    profession = viewModel.doctor.value.specialist?:"",
                    experience = viewModel.doctor.value.experience?:"",
                    waitTime = viewModel.doctor.value.timing?:"",
                    imagePath = viewModel.geturl.value ,
                    viewProfile = {},
                    bookAppointment = {},
                    isButtonsVisible = false
                )
                Log.d("doctor data","${viewModel.geturl}")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "About",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = viewModel.doctor.value.degree?:"",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Specialist",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = viewModel.doctor.value.specialist?:"",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Experience",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = viewModel.doctor.value.experience?:"",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDoctorProfile() {
    DoctorProfileScreen()
}