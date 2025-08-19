package com.example.myhealth.model

data class Patient(
    val id: Int = 0,
    val first_name: String = "",
    val last_name: String = "",
    val age: Int = 0,
    val gender: String = "",
    val phoneNo: String = "",
    val email: String = "",
    val password: String = "",
    val conf_password: String = "",
    val role: String = ""
)
