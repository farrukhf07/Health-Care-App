package com.example.myhealth.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.AdminUser
import com.example.myhealth.model.Patient
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.LOGIN_RESPONSE
import com.example.myhealth.utils.PATIENT_TABLE
import com.example.myhealth.utils.Preference
import com.google.gson.Gson
import javax.inject.Inject

class EditProfileVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    val fName = mutableStateOf(AppUtil.getPatient()?.first_name ?:"")
    val lName = mutableStateOf(AppUtil.getPatient()?.last_name ?: "")
    val age = mutableStateOf(AppUtil.getPatient()?.age ?:0)
    val gender = mutableStateOf(AppUtil.getPatient()?.gender ?:"")
    // User data and update status
    val userdata = mutableStateOf<Patient?>(AppUtil.getPatient())
    val isUpdated = mutableStateOf(false)
    // Get the current authenticated user
    val currentUser = AUTH.currentUser

    fun setFName(data: String){
        fName.value = data
    }
    fun setLName(data: String){
        lName.value = data
    }
    fun setAge(data: Int){
        age.value = data
    }
    fun setGender(data: String){
        gender.value = data
    }


    // Function to update the user profile in Firebase Realtime Database
    fun UpdateUser() {
        if (currentUser != null) {
            val userRef = PATIENT_TABLE.child(currentUser.uid)

            // Update the userdata object with the latest mutable state values
            val updatedUser = userdata.value?.copy(
                first_name = fName.value,
                last_name = lName.value,
                age = age.value,
                gender = gender.value
            )

            if (updatedUser != null) {
                val map = HashMap<String, Any>()
                map["id"] = updatedUser.id ?: 0
                map["first_name"] = updatedUser.first_name
                map["last_name"] = updatedUser.last_name
                map["age"] = updatedUser.age
                map["gender"] = updatedUser.gender

                // Update the data in Firebase Realtime Database
                userRef.updateChildren(map).addOnSuccessListener {
                    isUpdated.value = true // Update was successful
                    // store in shared preference
                    Preference.setStringValue(LOGIN_RESPONSE, Gson().toJson(updatedUser))
                }.addOnFailureListener {
                    isUpdated.value = false // Handle failure
                }
            } else {
                isUpdated.value = false // Handle case when userdata is null
            }
        }
    }

}