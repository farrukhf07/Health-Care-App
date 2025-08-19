package com.example.adminhealth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.model.AdminUser
import com.example.adminhealth.model.Pharmacy
import com.example.adminhealth.utils.PHARMACY
import javax.inject.Inject
import kotlin.random.Random

class PharmacySignupVm @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    val pharmacyName = mutableStateOf("")
    val pharmacyPhone = mutableStateOf("")
    val pharmacyLocation = mutableStateOf("")
    val pharmacyEmail = mutableStateOf("")
    val pharmacyPassword = mutableStateOf("")
    var pharmacyNameError = mutableStateOf(false)
    var pharmacyPhoneError = mutableStateOf(false)
    var pharmacyLocationError = mutableStateOf(false)
    var pharmacyEmailError = mutableStateOf(false)
    var pharmacyPasswordError = mutableStateOf(false)

    fun setPName(data:String){
        pharmacyName.value = data
    }
    fun setPPhone(data: String){
        pharmacyPhone.value = data
    }
    fun setPLocation(data: String){
        pharmacyLocation.value = data
    }
    fun setPEmail(data: String){
        pharmacyEmail.value = data
    }
    fun setPPassword(data: String){
        pharmacyPassword.value = data
    }

    fun errorNotFound():Boolean{
        return pharmacyName.value.isNotEmpty()&&pharmacyPhone.value.isNotEmpty()
                &&pharmacyLocation.value.isNotEmpty()&&pharmacyEmail.value.isNotEmpty()
                &&pharmacyPassword.value.isNotEmpty()
    }
    fun checkValues(){
        pharmacyNameError.value = pharmacyName.value.isEmpty()
        pharmacyPhoneError.value = pharmacyPhone.value.isEmpty()
        pharmacyLocationError.value = pharmacyLocation.value.isEmpty()
        pharmacyEmailError.value = pharmacyEmail.value.isEmpty()
        pharmacyPasswordError.value = pharmacyPassword.value.isEmpty()
    }

    fun createPharmacy():AdminUser{
        val id = Random.nextInt(1001,1490)
        val pharmacy = AdminUser(
            id = id,
            full_name = pharmacyName.value,
            phoneNo = pharmacyPhone.value,
            location = pharmacyLocation.value,
            email = pharmacyEmail.value,
            password = pharmacyPassword.value,
            role = PHARMACY,
            age = null,
            specialist = null,
            experience = null,
            degree = null,
            fee = null,
            timing = null,
            photo = null
        )
        return pharmacy
    }
}