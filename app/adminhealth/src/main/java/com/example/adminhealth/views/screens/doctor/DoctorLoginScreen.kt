package com.example.adminhealth.views.screens.doctor

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adminhealth.R
import com.example.adminhealth.model.AdminUser
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.ADMIN_TABLE
import com.example.adminhealth.utils.AUTH
import com.example.adminhealth.utils.DOCTOR
import com.example.adminhealth.utils.LOGIN_RESPONSE
import com.example.adminhealth.utils.PreferenceAdmin
import com.example.adminhealth.viewmodel.DocLoginVM
import com.example.adminhealth.views.components.CustomTextField
import com.google.gson.Gson
import java.util.prefs.Preferences

@Composable
fun DoctorLoginScreen(
    onDocDashboard:()->Unit,
    doctorSignUp:()->Unit,
    btnBack:()->Unit
) {
    val context = LocalContext.current
    val viewModel: DocLoginVM = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",
            alignment = Alignment.TopStart,
            modifier = Modifier.clickable { btnBack() }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Doctor Login",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 34.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Please enter login credentials provided by your admin",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { doctorSignUp() }
                .padding(start = 10.dp),
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .weight(0.8f)
        ) {
            CustomTextField(text = viewModel.email.value,
                onTextChange = {viewModel.setEmail(it)
                               viewModel.emailError.value = false},
                label = "Email",
                error = viewModel.emailError.value
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(text = viewModel.password.value,
                onTextChange = {viewModel.setPassword(it)
                               viewModel.passwordError.value = false},
                label = "Password",
                isPassword = true,
                error = viewModel.passwordError.value
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = {
                    if(viewModel.errorNotFound()){
                        AUTH.signInWithEmailAndPassword(viewModel.email.value, viewModel.password.value)
                            .addOnSuccessListener {
                                val userId = AUTH.currentUser?.uid
                                val database = ADMIN_TABLE
                                userId?.let { id->
                                    database.child(id).get().addOnSuccessListener { snapshot->

                                        val user = snapshot.getValue(AdminUser::class.java)
                                        val userRole = user?.role
                                        // save user through preferences
                                        PreferenceAdmin.setStringValue(LOGIN_RESPONSE, Gson().toJson(user))
                                        if(userRole == DOCTOR){
                                            Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
                                            onDocDashboard()
                                        }
                                        else{
                                            Toast.makeText(context, "Role miss match", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                            }.addOnFailureListener {
                                Toast.makeText(context, "Fail to Login", Toast.LENGTH_SHORT).show()
                            }
                    } else{
                        viewModel.checkValues()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
                    .wrapContentHeight(),
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = navyBlue,
                    contentColor = white
                )
            ) {
                Text(
                    text = "Log In",
                    modifier = Modifier.fillMaxWidth(),
                    color = white,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoginScreen() {
    DoctorLoginScreen(onDocDashboard = {}, doctorSignUp = {}, btnBack = {})
}