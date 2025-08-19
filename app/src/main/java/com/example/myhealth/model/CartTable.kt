package com.example.myhealth.model

data class CartTable(
    val id: Int = 0,
    val user_id: Int = 0,
    val medicine_id: Int = 0,
    val medicine_name: String = "",
    var price: Int = 0,
    var total_price: Int = 0,
    var quantity: Int = 1
)
