package com.example.adminhealth.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.model.AdminUser
import com.example.adminhealth.utils.ADMIN_TABLE
import com.example.adminhealth.utils.DOCTOR
import com.example.adminhealth.utils.IMAGE_STORAGE
import javax.inject.Inject
import kotlin.random.Random

class DocSignupVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val fullName = mutableStateOf("")
    val age = mutableStateOf("")
    val specialist = mutableStateOf("")
    val experience = mutableStateOf("")
    val degree = mutableStateOf("")
    val fees = mutableStateOf("")
    val phoneNo = mutableStateOf("")
    val timing = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
//    val imageUri = mutableStateOf<Uri?>(null)

    var fullNameError = mutableStateOf(false)
    var ageError = mutableStateOf(false)
    var specialistError = mutableStateOf(false)
    var experienceError = mutableStateOf(false)
    var degreeError = mutableStateOf(false)
    var feesError = mutableStateOf(false)
    var phoneNoError = mutableStateOf(false)
    var timingError = mutableStateOf(false)
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    fun setFullName(data: String){
        fullName.value = data
    }
    fun setAge(data: String){
        age.value = data
    }
    fun setSpecialist(data: String){
        specialist.value = data
    }
    fun setExperience(data: String){
        experience.value = data
    }
    fun setDegree(data: String){
        degree.value = data
    }
    fun setFee(data: String){
        fees.value = data
    }
    fun setPhoneNo(data: String){
        phoneNo.value = data
    }
    fun setTiming(data: String){
        timing.value = data
    }
    fun setEmail(data: String){
        email.value = data
    }
    fun setPassword(data: String){
        password.value = data
    }

    fun errorNotFound():Boolean{
        return fullName.value.isNotEmpty() && age.value.isNotEmpty()
                &&specialist.value.isNotEmpty() && experience.value.isNotEmpty()
                &&degree.value.isNotEmpty() && fees.value.isNotEmpty()
                &&phoneNo.value.isNotEmpty() && timing.value.isNotEmpty()
                &&email.value.isNotEmpty() && password.value.isNotEmpty()
    }

    fun checkValues(){
        fullNameError.value = fullName.value.isEmpty()
        ageError.value = age.value.isEmpty()
        specialistError.value = specialist.value.isEmpty()
        experienceError.value = experience.value.isEmpty()
        degreeError.value = degree.value.isEmpty()
        feesError.value = fees.value.isEmpty()
        phoneNoError.value = phoneNo.value.isEmpty()
        timingError.value = timing.value.isEmpty()
        emailError.value = email.value.isEmpty()
        passwordError.value = password.value.isEmpty()
    }

//    fun createDoctor(){
//        val id = Random.nextInt(1,1000)
//        imageUri.value?.let { uri->
//            IMAGE_STORAGE.child("${id}").putFile(uri).addOnSuccessListener { task->
//                task.metadata?.reference?.downloadUrl?.addOnSuccessListener {downloadUrl->
//                    val imgUrl = downloadUrl.toString()
//                    val doctor = AdminUser(
//                        id = id,
//                        full_name = fullName.value,
//                        age = age.value.toInt(),
//                        specialist = specialist.value,
//                        experience = experience.value,
//                        degree = degree.value,
//                        fee = fees.value.toInt(),
//                        phoneNo = phoneNo.value,
//                        timing = timing.value,
//                        email = email.value,
//                        password = password.value,
//                        photo = imgUrl,
//                        location = null,
//                        role = DOCTOR
//                    )
//                    ADMIN_TABLE.child("${id}").setValue(doctor)
//                }
//            }
//        }
//    }

}