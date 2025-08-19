package com.example.adminhealth.views.screens.doctor

import android.annotation.SuppressLint
import android.app.Activity
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.adminhealth.R
import com.example.adminhealth.model.AdminUser
import com.example.adminhealth.ui.theme.black
import com.example.adminhealth.ui.theme.gray
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.ADMIN_TABLE
import com.example.adminhealth.utils.AUTH
import com.example.adminhealth.utils.DOCTOR
import com.example.adminhealth.utils.IMAGE_STORAGE
import com.example.adminhealth.viewmodel.DocSignupVM
import com.example.adminhealth.views.components.CustomTextField
import kotlin.random.Random

@SuppressLint("UnrememberedMutableState")
@Composable
fun DocSignUpScreen(
    onLogin: () -> Unit
) {
    val context = LocalContext.current
    val viewModel: DocSignupVM = hiltViewModel()
    val imageUri = mutableStateOf<Uri?>(null)
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {uri->
            if(uri != null){
                Log.d("MY Image URI", "$uri")
                imageUri.value = uri
            }

        }
    )

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
                    text = viewModel.fullName.value,
                    onTextChange = {
                        viewModel.setFullName(it)
                        viewModel.fullNameError.value = false
                    },
                    label = "Full Name",
                    error = viewModel.fullNameError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.age.value,
                    onTextChange = {
                        viewModel.setAge(it)
                        viewModel.ageError.value = false
                    },
                    label = "Age",
                    error = viewModel.ageError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.specialist.value,
                    onTextChange = {
                        viewModel.setSpecialist(it)
                        viewModel.specialistError.value = false
                    },
                    label = "Specialist",
                    error = viewModel.specialistError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.experience.value,
                    onTextChange = {
                        viewModel.setExperience(it)
                        viewModel.experienceError.value = false
                    },
                    label = "Experience",
                    error = viewModel.experienceError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.degree.value,
                    onTextChange = {
                        viewModel.setDegree(it)
                        viewModel.degreeError.value = false
                    },
                    label = "Degree",
                    error = viewModel.degreeError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.fees.value,
                    onTextChange = {
                        viewModel.setFee(it)
                        viewModel.feesError.value = false
                    },
                    label = "Fees",
                    error = viewModel.feesError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.phoneNo.value,
                    onTextChange = {
                        viewModel.setPhoneNo(it)
                        viewModel.phoneNoError.value = false
                    },
                    label = "Contact Number",
                    error = viewModel.phoneNoError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.timing.value,
                    onTextChange = {
                        viewModel.setTiming(it)
                        viewModel.timingError.value = false
                    },
                    label = "Timing",
                    error = viewModel.timingError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.email.value,
                    onTextChange = {
                        viewModel.setEmail(it)
                        viewModel.emailError.value = false
                    },
                    label = "Email",
                    error = viewModel.emailError.value
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.password.value,
                    onTextChange = {
                        viewModel.setPassword(it)
                        viewModel.passwordError.value = false
                    },
                    label = "Password",
                    error = viewModel.passwordError.value,
                    isPassword = true
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(model = imageUri, contentDescription = "insert image")
                    Button(
                        onClick = {
                            filePickerLauncher.launch("image/*")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = gray,
                            contentColor = black
                        )
                    ) {
                        Text(text = "Select")
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (viewModel.errorNotFound()){
                        AUTH.createUserWithEmailAndPassword(viewModel.email.value, viewModel.password.value)
                            .addOnSuccessListener {
                                val userId = AUTH.currentUser?.uid
                                val id = Random.nextInt(1,499)
                                userId?.let {
                                    imageUri.value?.let { uri->
                                        IMAGE_STORAGE.child(it).putFile(uri).addOnSuccessListener { task->
                                            task.metadata?.reference?.downloadUrl?.addOnSuccessListener {downloadUrl->
                                                val imgUrl = downloadUrl.toString()
                                                val doctor = AdminUser(
                                                    id = id,
                                                    full_name = viewModel.fullName.value,
                                                    age = viewModel.age.value.toInt(),
                                                    specialist = viewModel.specialist.value,
                                                    experience = viewModel.experience.value,
                                                    degree = viewModel.degree.value,
                                                    fee = viewModel.fees.value.toInt(),
                                                    phoneNo = viewModel.phoneNo.value,
                                                    timing = viewModel.timing.value,
                                                    email = viewModel.email.value,
                                                    password = viewModel.password.value,
                                                    photo = imgUrl,
                                                    location = null,
                                                    role = DOCTOR
                                                )
                                                ADMIN_TABLE.child(it).setValue(doctor)
                                                    .addOnSuccessListener {
                                                        Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show()
                                                        onLogin()
                                                    }.addOnFailureListener {
                                                        Toast.makeText(context, "Error to registered", Toast.LENGTH_SHORT).show()
                                                    }
                                            }
                                        }.addOnFailureListener{
                                            Toast.makeText(context, "Fail to Upload Image", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                        }.addOnFailureListener {
                            Toast.makeText(context, "Auth Error", Toast.LENGTH_SHORT).show()
                        }
                    }else{
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

@Preview(showBackground = true)
@Composable
fun ShowSignupScreen() {
    DocSignUpScreen(onLogin = {})
}