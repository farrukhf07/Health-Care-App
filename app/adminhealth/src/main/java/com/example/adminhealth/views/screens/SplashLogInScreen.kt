package com.example.myhealth.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adminhealth.R
import com.example.adminhealth.ui.theme.black
import com.example.adminhealth.ui.theme.gray
import com.example.adminhealth.ui.theme.lightGreen1
import com.example.adminhealth.ui.theme.lightGreen2
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.newpurple
import com.example.adminhealth.ui.theme.primaryBlue
import com.example.adminhealth.ui.theme.purple
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.AppUtilAdmin
import com.example.adminhealth.utils.DOCTOR

@Composable
fun SplashLoginScreen(
    onDocLogin:()->Unit,
    onPharmLogin:()->Unit,
    onDocDashboard:()->Unit,
    onPharmacyDashboard:()->Unit
) {
    val context = LocalContext.current

    LaunchedEffect(Unit){
        if (AppUtilAdmin.getUser() != null){
            if (AppUtilAdmin.getUser()?.role == DOCTOR){
                onDocDashboard()
            }else{
                onPharmacyDashboard()
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.admin_background), contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(navyBlue),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Health Care App",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = white,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier
                    .background(newpurple)
                ) {
                    Column (
                        Modifier
                            .padding(10.dp)
                            .clickable { onDocLogin() }){
                        Text(text = "Insurance User?")
                        Text(
                            text = "Login Here",
                            color = purple,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Box(modifier = Modifier
                    .background(lightGreen2)
                ) {
                    Column (
                        Modifier
                            .padding(10.dp)
                            .clickable { onPharmLogin() }){
                        Text(text = "Corporate User?")
                        Text(
                            text = "Login Here",
                            color = lightGreen1,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoginScreen() {
    SplashLoginScreen(onPharmLogin = {}, onDocLogin = {}, onDocDashboard = {}, onPharmacyDashboard = {})
}