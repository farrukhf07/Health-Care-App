package com.example.myhealth.utils

import android.util.Patterns
import com.example.myhealth.model.Patient
import com.google.gson.Gson
import java.util.regex.Pattern

object AppUtil {
    fun isValidEmail(email: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    fun getPatient():Patient?{
        val stringResponse = Preference.getStringValue(LOGIN_RESPONSE, null)
        return Gson().fromJson(stringResponse, Patient::class.java)
    }
}