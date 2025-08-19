package com.example.myhealth.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.utils.AppUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val email = mutableStateOf("")
    val password = mutableStateOf("")

    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    fun setEmail(data: String){
        email.value = data
    }
    fun setPassword(data: String){
        password.value = data
    }

    fun errorNotFound(): Boolean{
        return email.value.isNotEmpty() && password.value.isNotEmpty()
    }
    fun checkValues(){
        emailError.value = (email.value.isEmpty() || !AppUtil.isValidEmail(email.value))
        passwordError.value = password.value.isEmpty()
    }
}