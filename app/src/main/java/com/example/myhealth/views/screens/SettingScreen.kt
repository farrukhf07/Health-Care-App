package com.example.myhealth.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.ui.theme.lightBlueBackground
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.viewModel.SettingVM
import com.example.myhealth.views.components.CustomTextField

@Composable
fun SettingScreen(
    update: () -> Unit
) {
    val viewModel: SettingVM = hiltViewModel()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBlueBackground)
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Account Settings",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(60.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .weight(1f)
        ) {
            CustomTextField(text = viewModel.currentPass.value, onTextChange = {
                viewModel.setCurrentPass(it)
            }, label = "Current Password", error = viewModel.currentPassError.value,
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
            CustomTextField(text = viewModel.newPass.value, onTextChange = {
                viewModel.setNewPass(it)
            }, label = "New Password", error = viewModel.newPassError.value,
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
            CustomTextField(text = viewModel.confPass.value, onTextChange = {
                viewModel.setConfPass(it)
            }, label = "Confirm Password", error = viewModel.confPassError.value,
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 20.dp)
        ) {
            Button(
                onClick = {
                    viewModel.updatePassword()
                    update()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = navyBlue,
                    contentColor = white
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = "Update",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowSettingScreen() {
    SettingScreen(update = {})
}