package com.example.adminhealth.views.screens.doctor

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adminhealth.R
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.AppUtilAdmin
import com.example.adminhealth.views.components.DoctorView

@Composable
fun DoctorDashboardScreen(
    addDisease:()->Unit,
    onSignout:()->Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.admin_background), contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(navyBlue)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Text(text = "Doctor Dashboard",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = white,
                        textAlign = TextAlign.Center
                    )
                    Image(painter = painterResource(id = R.drawable.ic_signout), contentDescription = "signout",
                        modifier = Modifier.size(25.dp).clickable { onSignout() })
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                DoctorView(
                    name = AppUtilAdmin.getUser()?.full_name?:"",
                    profession = AppUtilAdmin.getUser()?.specialist?:"",
                    experience = AppUtilAdmin.getUser()?.experience?:"",
                    waitTime = AppUtilAdmin.getUser()?.timing?:"",
                    photo = AppUtilAdmin.getUser()?.photo?:"",
                    addDisease = {addDisease()}
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowDoctorDashboard() {
    DoctorDashboardScreen(addDisease = {}, onSignout = {})
}