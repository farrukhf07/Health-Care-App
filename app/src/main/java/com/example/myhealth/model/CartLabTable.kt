package com.example.myhealth.model

data class CartLabTable(
    val id: Int = 0,
    val user_id: Int = 0,
    val test_id: Int = 0,
    val test_name: String = "",
    var price: Int = 0
)