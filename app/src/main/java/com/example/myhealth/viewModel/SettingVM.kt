package com.example.myhealth.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.LOGIN_RESPONSE
import com.example.myhealth.utils.PATIENT_TABLE
import com.example.myhealth.utils.Preference
import com.google.firebase.auth.EmailAuthProvider
import javax.inject.Inject

class SettingVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val currentPass = mutableStateOf("")
    val newPass = mutableStateOf("")
    val confPass = mutableStateOf("")
    val currentPassError = mutableStateOf(false)
    val newPassError = mutableStateOf(false)
    val confPassError = mutableStateOf(false)

    val userdata = mutableStateOf(AppUtil.getPatient())
    val isUpdated = mutableStateOf(false)

    fun setCurrentPass(data: String){
        currentPass.value = data
    }
    fun setNewPass(data: String){
        newPass.value = data
    }
    fun setConfPass(data: String){
        confPass.value = data
    }

    fun errorNotFound():Boolean{
        return currentPass.value.isNotEmpty()&&newPass.value.isNotEmpty()
                && newPass.value==confPass.value
    }
    fun checkValues(){
        currentPassError.value = currentPass.value.isEmpty()
        newPassError.value = newPass.value.isEmpty()
        confPassError.value = confPass.value.isEmpty()
    }

    fun updatePassword(){
        if(AUTH.currentUser != null && errorNotFound()){
            val userRef = PATIENT_TABLE.child(AUTH.currentUser!!.uid)

            val credential = EmailAuthProvider.getCredential(AUTH.currentUser!!.email!!, currentPass.value)
            AUTH.currentUser!!.reauthenticate(credential).addOnSuccessListener {
                val updatePassword = userdata.value?.copy(
                    password = newPass.value,
                    conf_password = confPass.value
                )

                if (updatePassword != null) {
                    val map = HashMap<String, Any>()
                    map["id"] = updatePassword.id
                    map["password"] = updatePassword.password
                    map["conf_password"] = updatePassword.conf_password

                    userRef.updateChildren(map).addOnSuccessListener {
                        isUpdated.value = true
                    }.addOnFailureListener {
                        isUpdated.value = false
                    }
                    AUTH.currentUser!!.updatePassword(newPass.value)
                } else {
                    checkValues()
                }
            }.addOnFailureListener {
                isUpdated.value = false
            }
        }
    }
}