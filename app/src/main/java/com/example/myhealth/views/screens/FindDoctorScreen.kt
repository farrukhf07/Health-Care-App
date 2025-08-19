package com.example.myhealth.views.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.model.AdminUser
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.FindDoctorVm
import com.example.myhealth.views.components.DoctorView

@Composable
fun FindDoctorScreen(
    btnBack:()->Unit,
    docProfile:(AdminUser)->Unit,
    appointment:()->Unit
) {
    val viewModel: FindDoctorVm = hiltViewModel()
    val doctor by viewModel.doctor
    LaunchedEffect(Unit){
        viewModel.fetchDoctorData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue),
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { btnBack() }, tint = white
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Specialities",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
        Text(text = "Choose a Specialty",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            this.items(doctor){
                Log.d("Image Path", it.photo ?: "No Image Path")
                DoctorView(
                    name = it.full_name?:"",
                    profession = it.specialist?:"",
                    experience = it.experience?:"",
                    waitTime = it.timing?:"",
                    imagePath = it.photo?:"",
                    bookAppointment = { btnBack() },
                    viewProfile = {docProfile(it)}
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowFindDoctor() {
    FindDoctorScreen(btnBack = {}, docProfile = {}, appointment = {})
}