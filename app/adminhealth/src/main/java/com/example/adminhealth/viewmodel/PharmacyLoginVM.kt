package com.example.adminhealth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.utils.AppUtilAdmin
import javax.inject.Inject

class PharmacyLoginVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    fun setEmail(data:String){
        email.value = data
    }
    fun setPassword(data:String){
        password.value = data
    }

    fun errorNotFound():Boolean{
        return email.value.isNotEmpty()&&password.value.isNotEmpty()
    }
    fun checkValues(){
        emailError.value = (email.value.isEmpty() || !AppUtilAdmin.isValidEmail(email.value))
        passwordError.value = password.value.isEmpty()
    }
}