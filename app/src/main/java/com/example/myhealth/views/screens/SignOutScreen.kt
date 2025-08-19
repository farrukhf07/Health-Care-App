package com.example.myhealth.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.LOGIN_RESPONSE
import com.example.myhealth.utils.Preference
import java.security.AllPermission

@Composable
fun SignOutScreen(
    onLogin:()->Unit
) {
    var showDialog by remember {
        mutableStateOf(false)
    }

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
                         showDialog = true
//            AUTH.signOut()
//            if (AUTH.currentUser == null){
//                Preference.setStringValue(LOGIN_RESPONSE, null)
//                onLogin()
//            }
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
        // showing dialogue
        if (showDialog){
            Dialog(onDismissRequest = { showDialog = false }) {
                Box(
                    modifier = Modifier
                        .background(white, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Are you sure to Log out",
                            fontSize = 18.sp,
                            color = black
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Row {
                            Button(onClick = {
                                AUTH.signOut()
                                if (AUTH.currentUser == null){
                                    Preference.setStringValue(LOGIN_RESPONSE, null)
                                    onLogin()
                                }
                                showDialog = false // close dialog
                            },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "OK")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { showDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Gray,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Cancel")
                            }
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowSignOutScreen() {
    SignOutScreen(onLogin = {})
}