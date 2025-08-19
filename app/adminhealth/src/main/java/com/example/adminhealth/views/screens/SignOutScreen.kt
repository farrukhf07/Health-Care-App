package com.example.adminhealth.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adminhealth.navigation.AdminMyHealthScreen
import com.example.adminhealth.ui.theme.black
import com.example.adminhealth.utils.AUTH
import com.example.adminhealth.utils.LOGIN_RESPONSE
import com.example.adminhealth.utils.PreferenceAdmin

@Composable
fun SignOutScreen(
    onLogin:()->Unit
) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Text(text = "Sign Out",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(onClick = {
            AUTH.signOut()
            if(AUTH.currentUser == null){
                PreferenceAdmin.setStringValue(LOGIN_RESPONSE, null)
                onLogin()
            }
        },
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Sign Out",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSignOutScreen() {
    SignOutScreen(onLogin = {})
}