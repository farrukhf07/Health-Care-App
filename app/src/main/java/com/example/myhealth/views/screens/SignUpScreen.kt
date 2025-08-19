package com.example.myhealth.views.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.PATIENT_TABLE
import com.example.myhealth.viewModel.SignUpVM
import com.example.myhealth.views.components.CustomTextField

@Composable
fun SignupScreen(
    onLogin: () -> Unit
) {
    val context = LocalContext.current
    val viewModel: SignUpVM = hiltViewModel()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
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
                    text = viewModel.fName.value,
                    onTextChange = { viewModel.setFname(it) },
                    label = "First Name",
                    error = viewModel.fNameError.value,
                    isPassword = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.lName.value,
                    onTextChange = { viewModel.setLname(it) },
                    label = "Last Name",
                    error = viewModel.lNameError.value,
                    isPassword = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.age.value,
                    onTextChange = { viewModel.setAge(it) },
                    label = "Age",
                    error = viewModel.ageError.value,
                    isPassword = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    viewModel.options.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            RadioButton(
                                selected = (option == viewModel.selectedOption.value),
                                onClick = { viewModel.selectedOption.value = option }
                            )
                            Text(
                                text = option,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.phoneNo.value,
                    onTextChange = { viewModel.setPhoneNo(it) },
                    label = "Contact Number",
                    error = viewModel.phoneNoError.value,
                    isPassword = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.email.value,
                    onTextChange = { viewModel.setEmail(it) },
                    label = "Email",
                    error = viewModel.emailError.value,
                    isPassword = false,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.password.value,
                    onTextChange = { viewModel.setPassword(it) },
                    label = "Password",
                    error = viewModel.passwordError.value,
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomTextField(
                    text = viewModel.confPass.value,
                    onTextChange = { viewModel.setConfPass(it) },
                    label = "Confirm Password",
                    error = viewModel.confPassError.value,
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {keyboardController?.hide()}
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (viewModel.errorNotFound()) {
                        AUTH.createUserWithEmailAndPassword(viewModel.email.value, viewModel.password.value)
                            .addOnSuccessListener {

//                         Preference.setStringValue(FIRST_NAME, viewModel.fName.value)
                                val userID = AUTH.currentUser?.uid
                                val patient = viewModel.createPatient()
                                userID?.let {
                                    PATIENT_TABLE.child(it).setValue(patient)
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

//@Preview(showBackground = true)
//@Composable
//fun ShowSignupScreen() {
//    SignupScreen()
//}