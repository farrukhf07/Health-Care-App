package com.example.myhealth.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.Patient
import com.example.myhealth.utils.Gender
import com.example.myhealth.utils.PATIENT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SignUpVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val fName = mutableStateOf("")
    val lName = mutableStateOf("")
    val age = mutableStateOf("")
    val phoneNo = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confPass = mutableStateOf("")
    val selectedOption = mutableStateOf("")
    val options = listOf(Gender.MALE.id, Gender.FEMALE.id)

    var fNameError = mutableStateOf(false)
    var lNameError = mutableStateOf(false)
    var ageError = mutableStateOf(false)
    var phoneNoError = mutableStateOf(false)
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)
    var confPassError = mutableStateOf(false)

    fun setFname(data: String){
        fName.value = data
    }
    fun setLname(data: String){
        lName.value = data
    }
    fun setAge(data: String){
        age.value = data
    }
    fun setPhoneNo(data: String){
        phoneNo.value = data
    }
    fun setEmail(data: String){
        email.value = data
    }
    fun setPassword(data: String){
        password.value = data
    }
    fun setConfPass(data: String){
        confPass.value = data
    }

    fun errorNotFound():Boolean{
        return fName.value.isNotEmpty()&&lName.value.isNotEmpty()
                &&age.value.isNotEmpty()&&selectedOption.value.isNotEmpty()
                &&phoneNo.value.isNotEmpty()&&email.value.isNotEmpty()
                &&password.value.isNotEmpty()&&password.value==confPass.value
    }
    fun checkValues(){
        fNameError.value = fName.value.isEmpty()
        lNameError.value = lName.value.isEmpty()
        ageError.value = age.value.isEmpty()
        phoneNoError.value = phoneNo.value.isEmpty()
        emailError.value = email.value.isEmpty()
        passwordError.value = password.value.isEmpty()
        confPassError.value = confPass.value.isEmpty()
    }

    fun createPatient(): Patient{
        val id = Random.nextInt(500,1000)
        val patient = Patient(
            id = id,
            first_name = fName.value,
            last_name = lName.value,
            age = age.value.toInt(),
            gender = selectedOption.value,
            phoneNo = phoneNo.value,
            email = email.value,
            password = password.value,
            conf_password = confPass.value,
            role = PATIENT
        )
        return patient
    }
}