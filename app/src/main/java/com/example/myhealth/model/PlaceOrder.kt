package com.example.myhealth.model

data class PlaceOrder(
    val id: Int = 0,
    val user_id: Int = 0,
    val medicine_id: Int ?= null,
    val test_id: Int ?= null,
    var price: Int = 0,
    var total_price: Int = 0,
    var quantity: Int ?= null
)
