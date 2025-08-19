package com.example.myhealth.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myhealth.ui.theme.gray
import com.example.myhealth.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    error: Boolean,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text(text = label) },
        singleLine = true,
        isError = error,
        visualTransformation = if (isPassword) { PasswordVisualTransformation() }
        else { VisualTransformation.None },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = white
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

//@Preview(showBackground = true)
//@Composable
//fun ShowTextField() {
//    CustomTextField(text = "", onTextChange = {}, label = "Hello", error = false)
//}