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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.model.Patient
import com.example.myhealth.ui.theme.Purple80
import com.example.myhealth.ui.theme.gray
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AppUtil

@Composable
fun PatientProfileScreen(
    editProfile:()->Unit,
    viewCart:()->Unit,
    setting:()->Unit,
    signOut:()->Unit
) {
//    val email = Preference.getStringValue(EMAIL,"")
//    val first_name = Preference.getStringValue(FIRST_NAME,"")
    Column(modifier = Modifier
        .fillMaxSize()
        .background(gray)) {
        Spacer(modifier = Modifier.height(80.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Card(
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = white
                )
            ) {
                Image(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "profile photo",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = AppUtil.getPatient()?.first_name?:"",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Row(modifier = Modifier
                .background(Purple80)
                .padding(4.dp)) {
                Text(text = AppUtil.getPatient()?.email?:"")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(white)
                .height(50.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ic_edit), contentDescription = "edit",
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Edit Profile",
                    fontSize = 22.sp
                )
                Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                    modifier = Modifier.size(30.dp).clickable { editProfile() } )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(white)
                .height(50.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "edit",
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "View Cart",
                    fontSize = 22.sp
                )
                Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                    modifier = Modifier.size(30.dp).clickable { viewCart() })
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(white)
                .height(50.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ic_settings), contentDescription = "edit",
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Settings",
                    fontSize = 22.sp
                )
                Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                    modifier = Modifier.size(30.dp).clickable { setting() })
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(white)
                .height(50.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ic_log_out), contentDescription = "edit",
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Logout",
                    fontSize = 22.sp
                )
                Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                    modifier = Modifier.size(30.dp).clickable { signOut() })
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowPatientProfile() {
//    PatientProfileScreen(
//        editProfile = {},
//        viewCart = {},
//        setting = {},
//        signOut = {})
//}