package com.example.myhealth.model

data class CartMedicine(
    val id: Int = 0,
    val user_id: Int = 0,
    val med_id: Int = 0,
    val price: Int = 0,
    val total_price: Int = 0,
    val quantity: Int = 1
)
