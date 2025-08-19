package com.example.adminhealth.model

data class Pharmacy(
    val id: Int = 0,
    val pharmacy_name: String = "",
    val phoneNo: String = "",
    val location: String = "", // unique form doc
    val email: String = "",
    val password: String = ""
)
