package com.example.adminhealth.utils

import android.util.Patterns
import com.example.adminhealth.model.AdminUser
import com.google.gson.Gson
import java.util.regex.Pattern

object AppUtilAdmin {
    fun isValidEmail(email: String): Boolean{
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    fun getUser():AdminUser?{
        val stringResponse = PreferenceAdmin.getStringValue(LOGIN_RESPONSE, null)
        return Gson().fromJson(stringResponse, AdminUser::class.java)
    }
}