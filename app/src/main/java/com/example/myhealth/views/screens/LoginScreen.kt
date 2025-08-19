package com.example.myhealth.views.screens

import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.model.Patient
import com.example.myhealth.ui.theme.gray
import com.example.myhealth.ui.theme.green
import com.example.myhealth.ui.theme.lightGreen1
import com.example.myhealth.ui.theme.lightGreen2
import com.example.myhealth.ui.theme.newpurple
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.purple
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.LOGIN_RESPONSE
import com.example.myhealth.utils.PATIENT
import com.example.myhealth.utils.PATIENT_TABLE
import com.example.myhealth.utils.Preference
import com.example.myhealth.viewModel.LoginVM
import com.example.myhealth.views.components.CustomTextField
import com.google.gson.Gson

@Composable
fun LoginScreen(
    onSignup:()->Unit,
    onDashboard:()->Unit,
) {
    val context = LocalContext.current
    val viewModel: LoginVM = hiltViewModel()
//    val emailfocusRequester = remember {FocusRequester()}
//    val passwordfocusRequester = remember {FocusRequester()}
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Log In",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 34.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
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
                    viewModel.emailError.value = false },
                label = "Email",
                error = viewModel.emailError.value,
                isPassword = false,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(text = viewModel.password.value,
                onTextChange = {viewModel.setPassword(it)
                    viewModel.passwordError.value = false },
                label = "Password",
                isPassword = true,
                error = viewModel.passwordError.value,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Don't have Account? SignUp",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSignup() },
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = {
                          if (viewModel.errorNotFound()){
                              AUTH.signInWithEmailAndPassword(viewModel.email.value, viewModel.password.value)
                                  .addOnSuccessListener{
//                                      Preference.setStringValue(EMAIL, viewModel.email.value)
                                  val userId = AUTH.currentUser?.uid
                                  val database = PATIENT_TABLE
                                  userId?.let { id->
                                      database.child(id).get().addOnSuccessListener {snapshot->

                                          val user = snapshot.getValue(Patient::class.java)
                                          val userRole = user?.role
                                          // save user through Preference
                                          Preference.setStringValue(LOGIN_RESPONSE, Gson().toJson(user))
                                          if(userRole == PATIENT){
                                              Toast.makeText(context, "Log In", Toast.LENGTH_SHORT).show()
                                              onDashboard()
                                          }else{
                                              Toast.makeText(context, "Role Miss match", Toast.LENGTH_SHORT).show()
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
                    .width(200.dp)
                    .padding(bottom = 30.dp)
                    .wrapContentHeight(),
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryBlue,
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

//@Preview(showBackground = true)
//@Composable
//fun ShowLoginScreen() {
//    LoginScreen()
//}