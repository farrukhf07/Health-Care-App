package com.example.adminhealth.views.screens.pharmacy

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.ADMIN_TABLE
import com.example.adminhealth.utils.AUTH
import com.example.adminhealth.viewmodel.PharmacySignupVm
import com.example.adminhealth.views.components.CustomTextField

@Composable
fun PharmacySignUpScreen(
    onLogin: () -> Unit
) {
    val context = LocalContext.current
    val viewModel: PharmacySignupVm = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "SignUp",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp)
        ) {
            items(1) {
                CustomTextField(
                    text = viewModel.pharmacyName.value,
                    onTextChange = {
                        viewModel.setPName(it)
                        viewModel.pharmacyNameError.value = false
                    },
                    label = "Pharmacy Name",
                    error = viewModel.pharmacyNameError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.pharmacyLocation.value,
                    onTextChange = {
                        viewModel.setPLocation(it)
                        viewModel.pharmacyLocationError.value = false
                    },
                    label = "Location",
                    error = viewModel.pharmacyLocationError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.pharmacyPhone.value,
                    onTextChange = {
                        viewModel.setPPhone(it)
                        viewModel.pharmacyPhoneError.value = false
                    },
                    label = "Phone Number",
                    error = viewModel.pharmacyPhoneError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.pharmacyEmail.value,
                    onTextChange = {
                        viewModel.setPEmail(it)
                        viewModel.pharmacyEmailError.value = false
                    },
                    label = "Email",
                    error = viewModel.pharmacyEmailError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.pharmacyPassword.value,
                    onTextChange = {
                        viewModel.setPPassword(it)
                        viewModel.pharmacyPasswordError.value = false
                    },
                    label = "Password",
                    error = viewModel.pharmacyPasswordError.value
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (viewModel.errorNotFound()) {
                        AUTH.createUserWithEmailAndPassword(
                            viewModel.pharmacyEmail.value,
                            viewModel.pharmacyPassword.value
                        )
                            .addOnSuccessListener {

                                val userId = AUTH.currentUser?.uid
                                val pharmacy = viewModel.createPharmacy()
                                userId?.let {
                                    ADMIN_TABLE.child(it).setValue(pharmacy)
                                        .addOnSuccessListener {
                                            Toast.makeText(context, "Registered!!", Toast.LENGTH_SHORT).show()
                                            onLogin()
                                        }.addOnFailureListener {
                                            Toast.makeText(context, "Error to Register", Toast.LENGTH_SHORT).show()
                                        }
                                }
                            }.addOnFailureListener {
                                Toast.makeText(context, "Check Credentials", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        viewModel.checkValues()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = navyBlue,
                    contentColor = white
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
                    .wrapContentHeight(),
                shape = RectangleShape,
                enabled = true
            ) {
                Text(
                    text = "Sign Up",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = white
                )
            }
        }
    }
}